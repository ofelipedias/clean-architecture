package br.com.felipesilva.domain.port;

import br.com.felipesilva.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface GetUserPort {

    User get(UUID uuid);

    User get(String name);

    List<User> getAll();
}
