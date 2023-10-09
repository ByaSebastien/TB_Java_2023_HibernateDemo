package be.bstorm.models.exo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Book {

    @Id
    private String ISBN;

    @Column(length = 150,unique = true,nullable = false)
    private  String title;

    private String literaturePrize;
}
