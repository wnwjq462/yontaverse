package org.teemyroom.yontaverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YontaverseApplication {

    public static void main(String[] args) {
        SpringApplication.run(YontaverseApplication.class, args);
    }

}
