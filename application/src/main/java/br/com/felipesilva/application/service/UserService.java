package br.com.felipesilva.application.service;

import br.com.felipesilva.application.domain.User;
import br.com.felipesilva.application.port.out.CreateUserPort;
import br.com.felipesilva.application.port.out.DeleteUserPort;
import br.com.felipesilva.application.port.out.GetUserPort;
import br.com.felipesilva.application.port.out.UpdateUserPort;
import br.com.felipesilva.application.port.in.CreateUserUseCase;
import br.com.felipesilva.application.port.in.DeleteUserUseCase;
import br.com.felipesilva.application.port.in.GetUserUseCase;
import br.com.felipesilva.application.port.in.UpdateUserUseCase;
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
