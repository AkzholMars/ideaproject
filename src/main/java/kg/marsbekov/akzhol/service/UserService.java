package kg.marsbekov.akzhol.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import kg.marsbekov.akzhol.dal.entity.UserEntity;
import kg.marsbekov.akzhol.dal.repository.UserRepository;
import kg.marsbekov.akzhol.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Valid
    public void createUser(String login, String eMail, String lastName, String firstName, LocalDate birthDate) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setEMail(eMail);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthDate(birthDate);
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return users.stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }

    public UserDto getUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("user.not.found");
        }
        return new UserDto(user.get());
    }
}

