package org.teemyroom.yontaverse.plot.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Message {
    private Long indexNumber;
    private String description;
    private String imagePath;
}
