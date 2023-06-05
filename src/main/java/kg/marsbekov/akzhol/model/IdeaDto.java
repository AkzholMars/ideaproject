package kg.marsbekov.akzhol.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kg.marsbekov.akzhol.dal.entity.IdeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDto {
    private Long id;

    @NotBlank(message = "text.not.empty")
    @Size(max = 100, message = "size.not.valid")
    private String text;
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd hh:MM:ss")
    private LocalDateTime createdDt;


    public IdeaDto(IdeaEntity entity) {
        this.id = entity.getId();
        this.text = entity.getText();
        this.userId = entity.getUser().getId();
        this.createdDt = entity.getCreatedDt();

    }
}
