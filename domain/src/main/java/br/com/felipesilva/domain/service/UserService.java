package br.com.felipesilva.domain.service;

import br.com.felipesilva.domain.model.User;
import br.com.felipesilva.domain.port.CreateUserPort;
import br.com.felipesilva.domain.port.DeleteUserPort;
import br.com.felipesilva.domain.port.GetUserPort;
import br.com.felipesilva.domain.port.UpdateUserPort;
import br.com.felipesilva.domain.usecase.CreateUserUseCase;
import br.com.felipesilva.domain.usecase.DeleteUserUseCase;
import br.com.felipesilva.domain.usecase.GetUserUseCase;
import br.com.felipesilva.domain.usecase.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService implements CreateUserUseCase, DeleteUserUseCase, GetUserUseCase, UpdateUserUseCase {


    private final GetUserPort getUserPort;
    private final CreateUserPort createUserPort;
    private final UpdateUserPort updateUserPort;
    private final DeleteUserPort deleteUserPort;

    @Override
    public User create(User user) {
        return createUserPort.create(user);

    }

    @Override
    public void delete(UUID uuid) {
        deleteUserPort.delete(uuid);
    }

    @Override
    public User get(UUID uuid) {
        return getUserPort.get(uuid);
    }

    @Override
    public User get(String name) {
        return getUserPort.get(name);
    }

    @Override
    public List<User> getAll() {
        return getUserPort.getAll();
    }

    @Override
    public void update(User user, UUID id) {
        updateUserPort.update(user, id);
    }
}
