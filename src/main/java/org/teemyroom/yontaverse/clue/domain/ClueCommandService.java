package org.teemyroom.yontaverse.clue.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class ClueCommandService extends BaseCommandService<Clue> {
    
    public ClueCommandService(ClueRepository clueRepository) {
        super(clueRepository);
    }
}
