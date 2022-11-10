package org.teemyroom.yontaverse.visitor.domain;

import org.teemyroom.yontaverse.auth.domain.Auth;
import org.teemyroom.yontaverse.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.teemyroom.yontaverse.place.domain.Place;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Visitor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authId")
    private Auth auth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId")
    private Place place;

    @Column(nullable = false)
    private Boolean clear = false;

    public Visitor(Auth auth, Place place) {
        this.auth = auth;
        this.place = place;
    }

    public void clear() {
        this.clear = true;
    }

    public void unclear() {
        this.clear = false;
    }
}
