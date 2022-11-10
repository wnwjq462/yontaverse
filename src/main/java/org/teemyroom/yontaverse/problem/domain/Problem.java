package org.teemyroom.yontaverse.problem.domain;

import org.teemyroom.yontaverse.clue.domain.Clue;
import org.teemyroom.yontaverse.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.teemyroom.yontaverse.place.domain.Place;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Problem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeId")
    private Place place;

    @Column(columnDefinition = "text", nullable = false)
    private String description;
    private String imagePath;
    @Column(nullable = false)
    private String answer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "problem")
    private Clue clue;

    public boolean match(String input) {
        return Objects.equals(this.answer, input);
    }
}
