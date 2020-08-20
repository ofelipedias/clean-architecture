package br.com.felipesilva.application.port.out;

import br.com.felipesilva.application.domain.User;

public interface CreateUserPort {

    User create(User user);
}
