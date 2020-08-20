package br.com.felipesilva.domain.usecase;

import br.com.felipesilva.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface GetUserUseCase {

    User get(UUID uuid);

    User get(String name);

    List<User> getAll();
}
