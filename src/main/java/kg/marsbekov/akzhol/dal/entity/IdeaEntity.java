package kg.marsbekov.akzhol.dal.entity;


import kg.marsbekov.akzhol.model.IdeaDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ideas")
public class IdeaEntity {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator"
    )
    private Long id;

    private String text;

    @Column(name = "created_dt", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDt;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity user;

    public IdeaEntity(IdeaDto dto) {
        this.text = dto.getText();
        this.user = new UserEntity(dto.getUserId());
    }
}
