package kg.marsbekov.akzhol.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import kg.marsbekov.akzhol.dal.entity.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {

    private String login;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;
    private List<IdeaDto> ideas;


    public UserDto(UserEntity entity) {
        this.login = entity.getLogin();
        this.createdDt = entity.getCreatedDt();
        this.ideas = entity.getIdeas()
                .stream().map(IdeaDto::new)
                .collect(Collectors.toList());
    }
}
