package org.teemyroom.yontaverse.auth.application.model.response;

import lombok.Getter;
import org.teemyroom.yontaverse.auth.domain.Auth;

@Getter
public class AuthResponse {
    private final Long id;
    private final String email;
    private final String name;

    public AuthResponse(Auth auth) {
        id = auth.getId();
        email = auth.getEmail();
        name = auth.getName();
    }
}
