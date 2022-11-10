package org.teemyroom.yontaverse.visitor.domain;

import org.teemyroom.yontaverse.common.BaseQueryService;
import org.springframework.stereotype.Service;

@Service
public class VisitorQueryService extends BaseQueryService<Visitor> {

    public VisitorQueryService(VisitorRepository visitorRepository) {
        super(visitorRepository);
    }
}
