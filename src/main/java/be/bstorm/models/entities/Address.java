package be.bstorm.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.*;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Address {

    @Column(name = "ADDRESS",nullable = false)
    public String address;
    @Column(name = "ADDRESS2",nullable = true)
    public String address2;
}
