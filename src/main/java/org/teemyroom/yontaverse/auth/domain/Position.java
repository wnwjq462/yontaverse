package org.teemyroom.yontaverse.auth.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Column(nullable = false)
    public Long x;
    @Column(nullable = false)
    public Long y;
}
