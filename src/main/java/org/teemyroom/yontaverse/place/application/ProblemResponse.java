package org.teemyroom.yontaverse.place.application;

import lombok.Getter;
import org.teemyroom.yontaverse.problem.domain.Problem;

@Getter
public class ProblemResponse {
    private final Long problemId;
    private final String description;
    private final String imagePath;

    public ProblemResponse(Problem problem) {
        this.problemId = problem.getId();
        this.description = problem.getDescription();
        this.imagePath = problem.getImagePath();
    }
}
