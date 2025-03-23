package com.zipte.platform.server.application.in.user;

import com.zipte.platform.server.adapter.in.web.dto.UserRequest;
import com.zipte.platform.server.domain.user.User;

public interface RegisterUserUseCase {
    /*
        유저로 회원가입 요청
     */

    User registerUser(UserRequest request);

}
