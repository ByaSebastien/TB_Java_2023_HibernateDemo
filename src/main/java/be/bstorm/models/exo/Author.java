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
public class Author {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50,nullable = false)
    private String firstname;

    @Column(length = 50,nullable = false)
    private String lastname;

    @Column(length = 50,nullable = true)
    private String pseudo;
}
