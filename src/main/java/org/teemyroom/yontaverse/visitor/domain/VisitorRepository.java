package org.teemyroom.yontaverse.visitor.domain;

import org.teemyroom.yontaverse.common.BaseRepository;

public interface VisitorRepository extends BaseRepository<Visitor> {
    void deleteByAuthId(Long authId);
}
