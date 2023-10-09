package be.bstorm.models.exo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class BookAuthor {

    @EmbeddedId
    private BookAuthorId bookAuthorId = new BookAuthorId();

    @ManyToOne
    @MapsId("bookId")
    private Book book;

    @ManyToOne
    @MapsId("authorId")
    private Author author;

    private int year;

    private double copyright;
}
