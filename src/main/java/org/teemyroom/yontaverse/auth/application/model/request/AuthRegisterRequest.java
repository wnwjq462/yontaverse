package org.teemyroom.yontaverse.auth.application.model.request;

import lombok.Data;
import org.teemyroom.yontaverse.auth.domain.Auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AuthRegisterRequest {
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String school;
    @NotBlank
    private String studentNumber;

    public Auth toEntity() {
        return new Auth(email, name, password, school, studentNumber);
    }
}
