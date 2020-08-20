package br.com.felipesilva.application.port.in;

import br.com.felipesilva.application.domain.User;

import java.util.List;
import java.util.UUID;

public interface GetUserUseCase {

    User get(UUID uuid);

    User get(String name);

    List<User> getAll();
}
