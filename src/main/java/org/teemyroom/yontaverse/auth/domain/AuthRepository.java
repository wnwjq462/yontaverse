package org.teemyroom.yontaverse.auth.domain;

import org.teemyroom.yontaverse.common.BaseRepository;

import java.util.Optional;

public interface AuthRepository extends BaseRepository<Auth> {

    Optional<Auth> findByEmail(String email);
}
