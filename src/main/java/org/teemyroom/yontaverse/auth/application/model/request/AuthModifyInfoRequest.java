package org.teemyroom.yontaverse.auth.application.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AuthModifyInfoRequest {
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
}
