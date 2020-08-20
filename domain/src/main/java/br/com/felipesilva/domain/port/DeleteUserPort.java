package br.com.felipesilva.domain.port;

import br.com.felipesilva.domain.model.User;

import java.util.UUID;

public interface DeleteUserPort {

    void delete(UUID uuid);
}
