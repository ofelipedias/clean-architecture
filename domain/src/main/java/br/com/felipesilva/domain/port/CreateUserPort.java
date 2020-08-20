package br.com.felipesilva.domain.port;

import br.com.felipesilva.domain.model.User;

public interface CreateUserPort {

    User create(User user);
}
