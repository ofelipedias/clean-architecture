package br.com.felipesilva.application.port.in;

import java.util.UUID;

public interface DeleteUserUseCase {

    void delete(UUID uuid);
}
