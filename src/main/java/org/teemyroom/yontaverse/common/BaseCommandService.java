package org.teemyroom.yontaverse.common;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseCommandService<T extends BaseEntity> {

    private final BaseRepository<T> repository;

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void deleteAll(List<T> entities) { repository.deleteAll(entities); }
}
