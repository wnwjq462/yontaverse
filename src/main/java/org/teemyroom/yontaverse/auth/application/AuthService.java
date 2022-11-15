package org.teemyroom.yontaverse.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teemyroom.yontaverse.auth.application.model.request.AuthLoginRequest;
import org.teemyroom.yontaverse.auth.application.model.request.AuthModifyInfoRequest;
import org.teemyroom.yontaverse.auth.application.model.request.AuthRegisterRequest;
import org.teemyroom.yontaverse.auth.application.model.response.AuthLoginResponse;
import org.teemyroom.yontaverse.auth.application.model.response.AuthResponse;
import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.auth.domain.AuthCommandService;
import org.teemyroom.yontaverse.auth.domain.AuthQueryService;
import org.teemyroom.yontaverse.common.exception.DuplicateResourceException;
import org.teemyroom.yontaverse.common.security.JwtTokenProvider;
import org.teemyroom.yontaverse.visitor.domain.Visitor;
import org.teemyroom.yontaverse.visitor.domain.VisitorCommandService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthQueryService authQueryService;
    private final VisitorCommandService visitorCommandService;
    private final AuthCommandService authCommandService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse getInfo(Long id) {
        return new AuthResponse(authQueryService.findById(id));
    }

    @Transactional
    public AuthResponse modifyInfo(Long id, AuthModifyInfoRequest request) {
        Auth auth = authQueryService.findById(id);
        System.out.println();
        System.out.println();
        auth.modifyInfo(request.getEmail(), request.getName(), passwordEncoder.encode(request.getPassword()));
        return new AuthResponse(auth);
    }

    @Transactional
    public void initialize(Long id) {
        Auth auth = authQueryService.findById(id);
        auth.initialize();
    }

    @Transactional
    public AuthResponse register(AuthRegisterRequest request) {
        authQueryService.findByEmail(request.getEmail())
                .ifPresent(value -> {
                    throw new DuplicateResourceException("이미 가입된 이메일입니다. email=" + request.getEmail());
                });

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        Auth auth = authCommandService.save(request.toEntity());
        return new AuthResponse(auth);
    }

    public AuthLoginResponse login(AuthLoginRequest request) {
        Auth auth = authQueryService.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일입니다. email=" + request.getEmail()));

        if (!passwordEncoder.matches(request.getPassword(), auth.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다");
        }

        String token = jwtTokenProvider.issueToken(auth.getId(), auth.getUsername());
        return new AuthLoginResponse(auth, token);
    }
}
