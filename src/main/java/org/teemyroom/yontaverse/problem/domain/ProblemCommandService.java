package org.teemyroom.yontaverse.problem.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class ProblemCommandService extends BaseCommandService<Problem> {
    
    public ProblemCommandService(ProblemRepository problemRepository) {
        super(problemRepository);
    }
}
