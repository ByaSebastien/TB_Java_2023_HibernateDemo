package be.bstorm.models.exo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class EditionBookStore {

    @EmbeddedId
    private EditionBookStoreId editionBookStoreId;

    @ManyToOne
    @MapsId("editionId")
    private Edition edition;

    @ManyToOne
    @MapsId("bookStoreId")
    private BookStore bookStore;

    private int quantity;

    @Temporal(TemporalType.DATE)
    private LocalDate commandDate;
}
