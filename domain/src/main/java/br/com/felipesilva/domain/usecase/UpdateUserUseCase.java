package br.com.felipesilva.domain.usecase;

import br.com.felipesilva.domain.model.User;

import java.util.UUID;

public interface UpdateUserUseCase {

    void update(User user, UUID id);
}
