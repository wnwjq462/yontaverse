package org.teemyroom.yontaverse.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.teemyroom.yontaverse.auth.application.AuthService;
import org.teemyroom.yontaverse.auth.application.model.request.AuthLoginRequest;
import org.teemyroom.yontaverse.auth.application.model.request.AuthModifyInfoRequest;
import org.teemyroom.yontaverse.auth.application.model.request.AuthRegisterRequest;
import org.teemyroom.yontaverse.auth.application.model.response.AuthLoginResponse;
import org.teemyroom.yontaverse.auth.application.model.response.AuthResponse;
import org.teemyroom.yontaverse.common.Response;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public Response.Item<AuthResponse> getInfo(
            HttpServletRequest httpServletRequest
    ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));
        return new Response.Item<>(authService.getInfo(authId));
    }

    @PutMapping
    public Response.Item<AuthResponse> modifyInfo(
            HttpServletRequest httpServletRequest,
            @Valid @RequestBody AuthModifyInfoRequest request
    ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));
        return new Response.Item<>(authService.modifyInfo(authId, request));
    }

    @PostMapping("/signup")
    public Response.Item<AuthResponse> signUp(@Valid @RequestBody AuthRegisterRequest request) {
        return new Response.Item<>(authService.register(request));
    }

    @PostMapping("/signin")
    public Response.Item<AuthLoginResponse> signIn(@Valid @RequestBody AuthLoginRequest request) {
        return new Response.Item<>(authService.login(request));
    }

    @PatchMapping("/initialize")
    @Transactional
    public Response.Empty initialize(
            HttpServletRequest httpServletRequest
    ) {
        Long authId = jwtTokenProvider.getAuthId(jwtTokenProvider.extractToken(httpServletRequest));

        authService.initialize(authId);

        return new Response.Empty();
    }
}
