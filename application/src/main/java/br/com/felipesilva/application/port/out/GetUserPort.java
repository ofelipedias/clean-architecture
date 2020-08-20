package br.com.felipesilva.application.port.out;

import br.com.felipesilva.application.domain.User;

import java.util.List;
import java.util.UUID;

public interface GetUserPort {

    User get(UUID uuid);

    User get(String name);

    List<User> getAll();
}
