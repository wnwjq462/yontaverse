package org.teemyroom.yontaverse.place.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.teemyroom.yontaverse.auth.domain.Position;


@Getter
@AllArgsConstructor
public class PlaceQueryResponse {
    private final String name;
    private final Position position;
    private final String description;
    private final String imagePath;
}
