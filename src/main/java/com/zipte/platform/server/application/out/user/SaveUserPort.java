package com.zipte.platform.server.application.out.user;

import com.zipte.platform.server.domain.user.User;

public interface SaveUserPort {

    User saveUser(User user);
}
