package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    @ManyToMany
    @JoinTable(name = "MUSICIAN_INSTRUMENT",
               joinColumns = @JoinColumn(name = "Musician_id"),
               inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instruments> instruments;
}
