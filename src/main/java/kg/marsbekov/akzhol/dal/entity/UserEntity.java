package kg.marsbekov.akzhol.dal.entity;

import jakarta.persistence.*;
import kg.marsbekov.akzhol.model.UserDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String login;

    @Column(name = "email")
    private String eMail;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "created_dt")
    @CreationTimestamp
    private LocalDateTime createdDt;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<IdeaEntity> ideas;
    public UserEntity(Long userId) {
        this.id = userId;
    }
    public UserEntity(UserDto dto) {
        this.login = dto.getLogin();
        this.eMail = dto.getEmail();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.birthDate = dto.getBirthDate();
    }
}
