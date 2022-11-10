package org.teemyroom.yontaverse.problem.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.auth.domain.AuthQueryService;
import org.teemyroom.yontaverse.common.exception.ResourceNotFoundException;
import org.teemyroom.yontaverse.problem.domain.Problem;
import org.teemyroom.yontaverse.problem.domain.ProblemQueryService;
import org.teemyroom.yontaverse.visitor.domain.Visitor;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemSolvingService {
    private final AuthQueryService authQueryService;
    private final ProblemQueryService problemQueryService;

    @Transactional
    public ProblemSolvingResponse solve(Long authId, Long problemId, String input) {
        Problem problem = problemQueryService.findById(problemId);

        if (problem.match(input)) {
            Auth auth = authQueryService.findById(authId);

            Optional<Visitor> targetVisitor = auth.getVisitors()
                    .stream()
                    .filter(visitor -> Objects.equals(visitor.getPlace(), problem.getPlace()))
                    .findAny();

            targetVisitor.orElseThrow(ResourceNotFoundException::new).clear();

            return new ProblemSolvingResponse(true, problem.getClue());
        } else {
            return new ProblemSolvingResponse(false);
        }
    }
}
