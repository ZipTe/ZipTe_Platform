package com.zipte.platform.server.adapter.out;

import com.zipte.platform.server.adapter.out.jpa.user.UserJpaEntity;
import com.zipte.platform.server.adapter.out.jpa.user.UserJpaEntityRepository;
import com.zipte.platform.server.application.out.user.LoadUserPort;
import com.zipte.platform.server.application.out.user.SaveUserPort;
import com.zipte.platform.server.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {

    private final UserJpaEntityRepository repository;

    @Override
    public User saveUser(User user) {
        var entity = UserJpaEntity.from(user);
        return repository.save(entity).toDomain();
    }

    @Override
    public Optional<User> loadUser(Long id) {
        return repository.findById(id)
                .map(UserJpaEntity::toDomain);
    }

    @Override
    public long loadAllUsers() {
        return repository.count();
    }


}
