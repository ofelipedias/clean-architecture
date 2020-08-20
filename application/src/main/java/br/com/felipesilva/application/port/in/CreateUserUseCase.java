package br.com.felipesilva.application.port.in;

import br.com.felipesilva.application.domain.User;

public interface CreateUserUseCase {

    User create(User user);
}
