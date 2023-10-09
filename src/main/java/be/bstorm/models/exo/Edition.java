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
public class Edition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;

    private String editionNumber;

    private int nbCopies;

    private double price;

    @ManyToOne
    private Book book;
}
