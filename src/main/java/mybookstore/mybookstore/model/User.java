package mybookstore.mybookstore.model;

import lombok.*;
import mybookstore.mybookstore.model.enums.Gender;
import mybookstore.mybookstore.model.enums.Role;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(name = "unique_constraint", columnNames = {"email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String email;
    private String name;
    private String surname;
    @NotNull
    @Length(min = 5)
    @ToString.Exclude
    private String password;
    @NotNull
    @Length(min = 5)
    @ToString.Exclude
    private String confirmPassword;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;

}
