package org.teemyroom.yontaverse.problem.application;

import lombok.Getter;
import org.teemyroom.yontaverse.clue.domain.Clue;

@Getter
public class ClueResponse {
    private final String name;
    private final String description;
    private final String imagePath;

    public ClueResponse(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public ClueResponse(Clue clue) {
        this.name = clue.getName();
        this.description = clue.getDescription();
        this.imagePath = getImagePath();
    }
}
