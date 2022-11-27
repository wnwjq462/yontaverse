package org.teemyroom.yontaverse.plot.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teemyroom.yontaverse.common.BaseQueryService;
import org.teemyroom.yontaverse.common.VisitType;
import org.teemyroom.yontaverse.plot.domain.Message;
import org.teemyroom.yontaverse.plot.domain.Plot;
import org.teemyroom.yontaverse.plot.domain.PlotQueryService;
import org.teemyroom.yontaverse.plot.domain.PlotRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlotByVisitTypeQueryService  {

    private final PlotQueryService plotQueryService;

    public List<Message> MessageByPlaceIdAndVisitType(Long placeId, VisitType visitType) {
        return plotQueryService.findByPlaceIdAndVisitType(placeId, visitType).getMessages();
    }

}
