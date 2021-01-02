package mybookstore.mybookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybookstore.mybookstore.model.enums.Genre;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "book", uniqueConstraints = @UniqueConstraint(name = "unique_isbn_constraint", columnNames = {"isbn"}))
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String isbn;
    private BigDecimal price;
    private LocalDate publishDate;
    private Integer pageSize;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;



}
