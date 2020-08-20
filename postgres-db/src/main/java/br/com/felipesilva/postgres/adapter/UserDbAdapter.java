package br.com.felipesilva.postgres.adapter;

import br.com.felipesilva.domain.exception.UserNotFoundException;
import br.com.felipesilva.domain.port.CreateUserPort;
import br.com.felipesilva.domain.port.DeleteUserPort;
import br.com.felipesilva.domain.port.GetUserPort;
import br.com.felipesilva.domain.port.UpdateUserPort;
import br.com.felipesilva.postgres.mapper.UserMapper;
import br.com.felipesilva.postgres.model.User;
import br.com.felipesilva.postgres.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserDbAdapter implements CreateUserPort, DeleteUserPort, GetUserPort, UpdateUserPort {

    private final UserRepository userRepository;

    @Override
    public br.com.felipesilva.domain.model.User create(br.com.felipesilva.domain.model.User user) {
        User entity = userRepository.save(UserMapper.toEntity(user));
        return UserMapper.fromEntity(entity);
    }

    @Override
    public void delete(UUID uuid) {
        userRepository.delete(User.builder().id(uuid).build());
    }

    @Override
    public br.com.felipesilva.domain.model.User get(UUID uuid) {
        Optional<User> optionalUser = userRepository.findById(uuid);
        return UserMapper.fromEntity(optionalUser.orElseThrow(() ->
                new UserNotFoundException("User not found by ID")));
    }

    @Override
    public br.com.felipesilva.domain.model.User get(String name) {
        Optional<User> optionalUser = userRepository.findByName(name);
        return UserMapper.fromEntity(optionalUser.orElseThrow(() ->
                new UserNotFoundException("User not found by Name")));
    }

    @Override
    public List<br.com.felipesilva.domain.model.User> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(br.com.felipesilva.domain.model.User user, UUID id) {
        User toUpdated = userRepository.getOne(id);
        toUpdated.setName(user.getName());
        toUpdated.setEmail(user.getEmail());
        userRepository.save(toUpdated);
    }
}
