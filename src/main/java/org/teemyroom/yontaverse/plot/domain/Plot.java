package org.teemyroom.yontaverse.plot.domain;

import org.teemyroom.yontaverse.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.teemyroom.yontaverse.common.VisitType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Plot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long placeId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VisitType visitType;

    @ElementCollection
    @CollectionTable(name="plotMessage", joinColumns = @JoinColumn(name="plotId", referencedColumnName = "id"))
    private List<Message> messages = new ArrayList<>();
}
