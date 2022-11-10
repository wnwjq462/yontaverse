package org.teemyroom.yontaverse.visitor.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.auth.domain.AuthQueryService;
import org.teemyroom.yontaverse.place.domain.Place;
import org.teemyroom.yontaverse.place.domain.PlaceQueryService;
import org.teemyroom.yontaverse.visitor.domain.Visitor;
import org.teemyroom.yontaverse.visitor.domain.VisitorCommandService;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitorCommandService commandService;
    private final AuthQueryService authQueryService;
    private final PlaceQueryService placeQueryService;

    @Transactional
    public void visit(Long authId, Long placeId) {
        Auth auth = authQueryService.findById(authId);
        Place place = placeQueryService.findById(placeId);
        commandService.save(new Visitor(auth, place));
    }
}
