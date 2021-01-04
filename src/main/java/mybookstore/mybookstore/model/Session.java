package mybookstore.mybookstore.model;

import lombok.*;
import mybookstore.mybookstore.model.enums.Gender;
import mybookstore.mybookstore.model.enums.Role;
import mybookstore.mybookstore.model.enums.SessionStatus;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String sessionId;
    @OneToOne
    private User user;
    @Enumerated(value = EnumType.STRING)
    private SessionStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
