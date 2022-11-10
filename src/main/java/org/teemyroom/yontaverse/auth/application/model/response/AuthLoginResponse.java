package org.teemyroom.yontaverse.auth.application.model.response;

import lombok.Getter;
import org.teemyroom.yontaverse.auth.domain.Auth;

@Getter
public class AuthLoginResponse {
    private final Long id;
    private final String email;
    private final String name;
    private final String token;

    public AuthLoginResponse(Auth auth, String token) {
        id = auth.getId();
        email = auth.getEmail();
        name = auth.getName();
        this.token = token;
    }
}
