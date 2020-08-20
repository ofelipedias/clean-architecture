package br.com.felipesilva.postgres.mapper;

import br.com.felipesilva.postgres.model.User;

public class UserMapper {

    public static User toEntity(br.com.felipesilva.domain.model.User user) {
        return User.builder()
                .name(user.getName())
                .email(user.getEmail()).build();
    }

    public static br.com.felipesilva.domain.model.User fromEntity(User user) {
        return br.com.felipesilva.domain.model.User.builder()
                .name(user.getName())
                .email(user.getEmail()).build();
    }
}
