package org.teemyroom.yontaverse.place.domain;

import org.teemyroom.yontaverse.auth.domain.Position;
import org.teemyroom.yontaverse.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.teemyroom.yontaverse.problem.domain.Problem;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Place extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Position position;

    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private String imagePath;
    private Long previousPlaceId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "place")
    private Problem problem;
}
