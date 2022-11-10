package org.teemyroom.yontaverse.place.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class PlaceCommandService extends BaseCommandService<Place> {
    
    public PlaceCommandService(PlaceRepository placeRepository) {
        super(placeRepository);
    }
}
