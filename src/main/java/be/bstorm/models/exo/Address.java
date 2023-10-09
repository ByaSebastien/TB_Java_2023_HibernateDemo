package be.bstorm.models.exo;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Address {

    private String street;
    private String number;
    private String town;
    private String zipCode;
}
