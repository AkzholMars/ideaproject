package kg.marsbekov.akzhol.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import kg.marsbekov.akzhol.dal.entity.IdeaEntity;
import kg.marsbekov.akzhol.dal.entity.UserEntity;
import kg.marsbekov.akzhol.dal.repository.IdeaRepository;
import kg.marsbekov.akzhol.dal.repository.UserRepository;
import kg.marsbekov.akzhol.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;



import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Valid
    public void createUser(UserDto user/*String login, String eMail, String lastName, String firstName, LocalDate birthDate*/) {
        UserEntity entity = new UserEntity(user);
//        user.setLogin(login);
//        user.setEMail(eMail);
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setBirthDate(birthDate);
        userRepository.save(entity);
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
    private IdeaEntity entity;
    public void deleteIdea(Long id) {
        userRepository.deleteById(id);
    }

}

