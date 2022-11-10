package org.teemyroom.yontaverse.place.application;

import lombok.Getter;
import org.teemyroom.yontaverse.common.VisitType;
import org.teemyroom.yontaverse.plot.domain.Message;
import org.teemyroom.yontaverse.problem.domain.Problem;

import java.util.List;

@Getter
public class PlaceEnterResponse {
    private final Long placeId;
    private final VisitType visitType;
    private final List<Message> messages;
    private final ProblemResponse problemResponse;

    public PlaceEnterResponse(Long placeId, VisitType visitType, List<Message> messages, Problem problem) {
        this.placeId = placeId;
        this.visitType = visitType;
        this.messages = messages;
        this.problemResponse = new ProblemResponse(problem);
    }
}
