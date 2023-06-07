package kg.marsbekov.akzhol.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kg.marsbekov.akzhol.dal.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "login.not.blank")
    @Size(min = 5, max = 20, message = "login.size")
    private String login;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;

    @Email(message = "email.not.valid")
    @NotBlank(message = "email.not.blank")
    private String email;

    @NotNull(message = "birthD.not.blank")
    private LocalDate birthDate;

    private String firstName;
    private String LastName;
    private List<IdeaDto> ideas;


    public UserDto(UserEntity entity) {
        this.login = entity.getLogin();
        this.createdDt = entity.getCreatedDt();
        this.ideas = entity.getIdeas()
                .stream().map(IdeaDto::new)
                .collect(Collectors.toList());
    }
}
