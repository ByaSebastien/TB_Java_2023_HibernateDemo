package be.bstorm.models.exo;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class EditionBookStoreId implements Serializable {

    private Long editionId;
    private Long bookStoreId;
}
