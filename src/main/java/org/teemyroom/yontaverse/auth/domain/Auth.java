package org.teemyroom.yontaverse.auth.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.teemyroom.yontaverse.common.BaseEntity;
import org.teemyroom.yontaverse.visitor.domain.Visitor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Auth extends BaseEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean clear = false;

    private String school;
    private String studentNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auth", orphanRemoval = true)
    private List<Visitor> visitors = new ArrayList<>();

    public Auth(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Auth(String email, String name, String password, String school, String studentNumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.school = school;
        this.studentNumber = studentNumber;
    }

    public void modifyInfo(String email, String name, String password) {
        if (StringUtils.isNotBlank(email)) {
            this.email = email;
        }
        if (StringUtils.isNotBlank(name)) {
            this.name = name;
        }
        if (StringUtils.isNotBlank(password)) {
            this.password = password;
        }
    }

    public void clear() {
        this.clear = true;
    }

    public void initialize() {
        this.clear = false;
        this.visitors.clear();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
