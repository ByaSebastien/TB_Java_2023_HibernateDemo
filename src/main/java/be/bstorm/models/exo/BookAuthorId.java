package be.bstorm.models.exo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@ToString @EqualsAndHashCode
public class BookAuthorId implements Serializable {

    private String bookId;
    private Long authorId;
}
