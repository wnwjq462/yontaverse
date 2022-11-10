package org.teemyroom.yontaverse.clue.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teemyroom.yontaverse.clue.application.HavingClueQueryService;
import org.teemyroom.yontaverse.common.Response;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;
import org.teemyroom.yontaverse.problem.application.ClueResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/clue")
@RequiredArgsConstructor
public class ClueQueryController {
    private final HavingClueQueryService havingClueQueryService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public Response.Item<List<ClueResponse>> query(
            HttpServletRequest httpServletRequest
    ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));

        return new Response.Item<>(havingClueQueryService.query(authId));
    }
}
