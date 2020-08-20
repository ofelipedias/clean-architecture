package br.com.felipesilva.domain.port;

import br.com.felipesilva.domain.model.User;

import java.util.UUID;

public interface UpdateUserPort {

    void update(User user, UUID id);
}
