package org.teemyroom.yontaverse.auth.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class AuthCommandService extends BaseCommandService<Auth> {
    
    public AuthCommandService(AuthRepository authRepository) {
        super(authRepository);
    }
}
