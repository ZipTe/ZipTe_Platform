package com.zipte.platform.server.application.out.user;

import com.zipte.platform.server.domain.user.User;

import java.util.Optional;

public interface LoadUserPort {

    // 유저 가져오기
    Optional<User> loadUser(Long id);

    // 유저 수 파악
    long loadAllUsers();


}
