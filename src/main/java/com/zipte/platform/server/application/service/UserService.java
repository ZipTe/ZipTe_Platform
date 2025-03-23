package com.zipte.platform.server.application.service;

import com.zipte.platform.server.adapter.in.web.dto.UserRequest;
import com.zipte.platform.server.application.in.user.LoginUserUseCase;
import com.zipte.platform.server.application.in.user.RegisterUserUseCase;
import com.zipte.platform.server.application.in.user.UpdateUserProfileUseCase;
import com.zipte.platform.server.application.out.user.SaveUserPort;
import com.zipte.platform.server.domain.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements RegisterUserUseCase, LoginUserUseCase, UpdateUserProfileUseCase {

    private final SaveUserPort savePort;

    @Override
    public User registerUser(UserRequest request) {
        User user = User.of(request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber());

        return savePort.saveUser(user);
    }

}
