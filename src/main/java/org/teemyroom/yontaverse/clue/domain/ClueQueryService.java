package org.teemyroom.yontaverse.clue.domain;

import org.teemyroom.yontaverse.common.BaseQueryService;
import org.springframework.stereotype.Service;

@Service
public class ClueQueryService extends BaseQueryService<Clue> {

    public ClueQueryService(ClueRepository clueRepository) {
        super(clueRepository);
    }
}
