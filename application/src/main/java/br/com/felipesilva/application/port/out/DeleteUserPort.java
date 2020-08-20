package br.com.felipesilva.application.port.out;

import java.util.UUID;

public interface DeleteUserPort {

    void delete(UUID uuid);
}
