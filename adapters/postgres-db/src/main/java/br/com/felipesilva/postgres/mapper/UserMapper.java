package br.com.felipesilva.postgres.mapper;

import br.com.felipesilva.postgres.model.User;

public class UserMapper {

    public static User toEntity(br.com.felipesilva.application.domain.User user) {
        return User.builder()
                .name(user.getName())
                .email(user.getEmail()).build();
    }

    public static br.com.felipesilva.application.domain.User fromEntity(User user) {
        return br.com.felipesilva.application.domain.User.builder()
                .name(user.getName())
                .email(user.getEmail()).build();
    }
}
