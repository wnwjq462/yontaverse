package org.teemyroom.yontaverse.place.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.auth.domain.AuthQueryService;
import org.teemyroom.yontaverse.common.VisitType;
import org.teemyroom.yontaverse.place.domain.Place;
import org.teemyroom.yontaverse.place.domain.PlaceQueryService;
import org.teemyroom.yontaverse.plot.domain.Message;
import org.teemyroom.yontaverse.plot.domain.PlotQueryService;
import org.teemyroom.yontaverse.visitor.application.VisitService;
import org.teemyroom.yontaverse.visitor.domain.Visitor;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlaceEnterService {
    private final VisitService visitService;
    private final PlaceQueryService placeQueryService;
    private final AuthQueryService authQueryService;
    private final PlotQueryService plotQueryService;

    @Transactional
    public PlaceEnterResponse enter(Long authId, Long placeId) {
        Place place = placeQueryService.findById(placeId);
        Auth auth = authQueryService.findById(authId);

        List<Visitor> authVisitors = auth.getVisitors();
        VisitType visitType;
        Optional<Visitor> targetVisitor =
            authVisitors.stream().filter(visitor -> Objects.equals(visitor.getPlace().getId(), placeId)).findAny();


        if (targetVisitor.isPresent()) {
            if (targetVisitor.get().getClear()) {
                visitType = VisitType.SOLVED;
            } else {
                visitType = VisitType.VISITED;
            }
        } else {
            visitType = VisitType.UNVISITED;
        }


        if (place.getPreviousPlaceId() != null) {
            Optional<Visitor> previousVisitor =
                    authVisitors
                            .stream()
                            .filter(visitor -> visitor.getPlace().getId() == place.getPreviousPlaceId())
                            .findAny();

            boolean previousCleared =
                    previousVisitor.orElseThrow(PreviousPlaceNotClearedException::new).getClear();

            if (!previousCleared)
                throw new PreviousPlaceNotClearedException();
        }

        if (visitType == VisitType.UNVISITED) {
            visitService.visit(authId, placeId);
        }

        List<Message> messages = plotQueryService.findByPlaceIdAndVisitType(placeId, visitType).getMessages();

        return new PlaceEnterResponse(
                placeId,
                visitType,
                messages,
                place.getProblem()
        );
    }
}
