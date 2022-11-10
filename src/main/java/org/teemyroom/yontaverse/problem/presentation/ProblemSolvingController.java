package org.teemyroom.yontaverse.problem.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.teemyroom.yontaverse.common.Response;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;
import org.teemyroom.yontaverse.problem.application.ProblemSolvingRequest;
import org.teemyroom.yontaverse.problem.application.ProblemSolvingResponse;
import org.teemyroom.yontaverse.problem.application.ProblemSolvingService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/problem")
@RequiredArgsConstructor
public class ProblemSolvingController {
    private final ProblemSolvingService problemSolvingService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("{problemId}/solve")
    public Response.Item<ProblemSolvingResponse> solve(
            HttpServletRequest httpServletRequest,
            @PathVariable Long problemId,
            @RequestBody ProblemSolvingRequest request
            ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));

        return new Response.Item<>(problemSolvingService.solve(authId, problemId, request.answer));
    }
}
