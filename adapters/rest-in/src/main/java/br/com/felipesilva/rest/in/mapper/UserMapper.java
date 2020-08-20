package br.com.felipesilva.rest.in.mapper;

import br.com.felipesilva.application.domain.User;
import br.com.felipesilva.rest.in.model.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail()).build();
    }

    public static User fromDto(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail()).build();
    }
}
