package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
public class Instruments {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter @Setter
    private String name;

    @ManyToMany(mappedBy = "instruments")
    private Set<Musician> musicians;
}















