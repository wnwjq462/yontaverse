package org.teemyroom.yontaverse.place.domain;

import org.springframework.stereotype.Service;
import org.teemyroom.yontaverse.common.BaseQueryService;
import org.teemyroom.yontaverse.common.exception.ResourceNotFoundException;

@Service
public class PlaceQueryService extends BaseQueryService<Place> {
    private final PlaceRepository repository;

    public PlaceQueryService(PlaceRepository placeRepository) {
        super(placeRepository);
        repository = placeRepository;
    }

    public Place findById(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
