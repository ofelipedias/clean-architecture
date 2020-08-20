package br.com.felipesilva.application.port.in;

import br.com.felipesilva.application.domain.User;

import java.util.UUID;

public interface UpdateUserUseCase {

    void update(User user, UUID id);
}
