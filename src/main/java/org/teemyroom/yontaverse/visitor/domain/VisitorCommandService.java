package org.teemyroom.yontaverse.visitor.domain;

import org.springframework.transaction.annotation.Transactional;
import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorCommandService extends BaseCommandService<Visitor> {

    private final VisitorRepository repository;
    
    public VisitorCommandService(VisitorRepository visitorRepository) {
        super(visitorRepository);
        repository = visitorRepository;
    }

    @Transactional
    public void deleteByAuthId(Long authId) {
        repository.deleteByAuthId(authId);
    }

    @Transactional
    public void deleteByIds(List<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
