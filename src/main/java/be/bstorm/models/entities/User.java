package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "USER_")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME",length = 50,nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME",length = 50,nullable = false)
    private String lastname;

    @Column(name = "BIRTH_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Column(name = "GENRE",nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreType genre;

    @Embedded
    private Address address;

    public User(String firstname, String lastname, LocalDate birthdate, GenreType genre, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.genre = genre;
        this.address = address;
    }
}
