package org.teemyroom.yontaverse.problem.domain;

import org.teemyroom.yontaverse.common.BaseRepository;

import java.util.Optional;

public interface ProblemRepository extends BaseRepository<Problem> {
    Optional<Problem> findById(Long id);
    Optional<Problem> findByPlaceId(Long placeId);
}
