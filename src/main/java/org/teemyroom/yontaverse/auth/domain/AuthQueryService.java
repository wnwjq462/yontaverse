package org.teemyroom.yontaverse.auth.domain;

import org.teemyroom.yontaverse.common.BaseQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthQueryService extends BaseQueryService<Auth> {

    private final AuthRepository authRepository;

    public AuthQueryService(AuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }

    public Optional<Auth> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }
}
