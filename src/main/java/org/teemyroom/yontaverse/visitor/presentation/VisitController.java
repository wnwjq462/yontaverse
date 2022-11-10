package org.teemyroom.yontaverse.visitor.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.teemyroom.yontaverse.common.Response;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;
import org.teemyroom.yontaverse.visitor.application.VisitService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/visit")
@RequiredArgsConstructor
public class VisitController {

    private final JwtTokenProvider jwtTokenProvider;
    private final VisitService visitService;

    @PostMapping
    public Response.Empty visit(
            @RequestParam(name = "placeId") Long placeId,
            HttpServletRequest httpServletRequest
    ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));

        visitService.visit(authId, placeId);

        return new Response.Empty();
    }
}
