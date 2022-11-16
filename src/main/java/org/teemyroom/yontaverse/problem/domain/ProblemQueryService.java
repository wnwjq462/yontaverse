package org.teemyroom.yontaverse.problem.domain;

import org.teemyroom.yontaverse.common.BaseQueryService;
import org.springframework.stereotype.Service;
import org.teemyroom.yontaverse.common.exception.ResourceNotFoundException;

@Service
public class ProblemQueryService extends BaseQueryService<Problem> {
    private final ProblemRepository repository;

    public ProblemQueryService(ProblemRepository problemRepository) {
        super(problemRepository);
        repository = problemRepository;
    }

    public Problem findById(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Problem findByPlaceId(Long placeId) {
        return repository.findByPlaceId(placeId).orElseThrow(ResourceNotFoundException::new);
    }
}
