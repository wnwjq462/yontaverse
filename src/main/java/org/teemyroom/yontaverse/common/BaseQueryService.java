package org.teemyroom.yontaverse.common;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.teemyroom.yontaverse.common.exception.ResourceNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseQueryService<T extends BaseEntity> {

    private final BaseRepository<T> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Page<T> findByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
