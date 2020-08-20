package br.com.felipesilva.application.port.out;

import br.com.felipesilva.application.domain.User;

import java.util.UUID;

public interface UpdateUserPort {

    void update(User user, UUID id);
}
