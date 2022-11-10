package org.teemyroom.yontaverse.problem.application;

import lombok.Getter;
import org.teemyroom.yontaverse.clue.domain.Clue;

@Getter
public class ProblemSolvingResponse {
    private final boolean correct;
    private final ClueResponse clueResponse;

    public ProblemSolvingResponse(boolean correct, Clue clue) {
        this.correct = correct;
        this.clueResponse = new ClueResponse(
                clue.getName(),
                clue.getDescription(),
                clue.getImagePath()
        );
    }

    public ProblemSolvingResponse(boolean correct) {
        this.correct = correct;
        this.clueResponse = null;
    }
}
