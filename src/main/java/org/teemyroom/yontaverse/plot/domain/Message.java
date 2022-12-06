package org.teemyroom.yontaverse.plot.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Message {
    public Long indexNumber;
    public String description;
    public String imagePath;
}
