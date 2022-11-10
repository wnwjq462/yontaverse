package org.teemyroom.yontaverse.clue.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.auth.domain.AuthQueryService;
import org.teemyroom.yontaverse.clue.domain.ClueQueryService;
import org.teemyroom.yontaverse.problem.application.ClueResponse;
import org.teemyroom.yontaverse.visitor.domain.Visitor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HavingClueQueryService {
    private final AuthQueryService authQueryService;

    public List<ClueResponse> query(Long authId) {
        Auth auth = authQueryService.findById(authId);

        return auth.getVisitors()
                .stream()
                .filter(Visitor::getClear)
                .map(
                        visitor -> new ClueResponse(visitor.getPlace().getProblem().getClue())
                )
                .collect(Collectors.toList());
    }
}
