package org.teemyroom.yontaverse.place.domain;

import org.teemyroom.yontaverse.common.BaseRepository;

import java.util.Optional;

public interface PlaceRepository extends BaseRepository<Place> {
    Optional<Place> findById(Long id);
}
