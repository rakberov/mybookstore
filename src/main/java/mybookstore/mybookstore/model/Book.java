package mybookstore.mybookstore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mybookstore.mybookstore.model.enums.Genre;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    @Length(min = 13, max = 13)
    private String isbn;
    @NotNull
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
    private Integer pageSize;
    private String description;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Genre genre;
    private String imageName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<BookReview> reviews = new ArrayList<>();

    public BigDecimal getRating() {
        if (reviews.isEmpty()) return null;

        BigDecimal totalRating = BigDecimal.ZERO;
        for(BookReview review: reviews)
            totalRating = totalRating.add(review.getRating());

        return totalRating.divide(BigDecimal.valueOf(reviews.size()));
    }
}
