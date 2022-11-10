package org.teemyroom.yontaverse.place.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teemyroom.yontaverse.common.Response;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;
import org.teemyroom.yontaverse.place.application.PlaceEnterResponse;
import org.teemyroom.yontaverse.place.application.PlaceEnterService;
import org.teemyroom.yontaverse.plot.domain.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/place")
@RequiredArgsConstructor
public class PlaceEnterController {
    private final PlaceEnterService placeEnterService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("{placeId}/enter")
    public Response.Item<PlaceEnterResponse> enter(
            @PathVariable Long placeId,
            HttpServletRequest httpServletRequest
            ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));

        return new Response.Item<>(placeEnterService.enter(authId, placeId));
    }
}
