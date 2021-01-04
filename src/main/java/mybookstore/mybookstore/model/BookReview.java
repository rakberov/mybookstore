package mybookstore.mybookstore.model;

import lombok.*;
import mybookstore.mybookstore.model.enums.SessionStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "book_review")
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String comment;
    private BigDecimal rating;
    @ManyToOne
    private User user;
    @ManyToOne
    @ToString.Exclude
    private Book book;
}
