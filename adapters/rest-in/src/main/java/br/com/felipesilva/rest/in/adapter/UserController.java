package br.com.felipesilva.rest.in.adapter;

import br.com.felipesilva.application.domain.User;
import br.com.felipesilva.application.port.in.CreateUserUseCase;
import br.com.felipesilva.application.port.in.DeleteUserUseCase;
import br.com.felipesilva.application.port.in.GetUserUseCase;
import br.com.felipesilva.application.port.in.UpdateUserUseCase;
import br.com.felipesilva.rest.in.mapper.UserMapper;
import br.com.felipesilva.rest.in.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAll() {
        return getUserUseCase.getAll().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable UUID id) {
        return UserMapper.toDto(getUserUseCase.get(id));
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getByName(@RequestParam String name) {
        return UserMapper.toDto(getUserUseCase.get(name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto) {
        User user = createUserUseCase.create(UserMapper.fromDto(userDto));
        return UserMapper.toDto(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody UserDto userDTO, @PathVariable UUID id) {
        updateUserUseCase.update(UserMapper.fromDto(userDTO), id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        deleteUserUseCase.delete(id);
    }
}
