package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
@ToString(of = {"id","name"}) @EqualsAndHashCode(of = {"id","name"})
public class Municipality {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(length = 50)
    @Getter @Setter
    private String name;

    @Getter
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
              fetch = FetchType.EAGER)
    @JoinColumn(name = "MAYOR_ID")
    private Mayor mayor;

    @ManyToOne(cascade = CascadeType.PERSIST,
               fetch = FetchType.EAGER)
    private Province province;

    public void setMayor(Mayor mayor){
        this.mayor = mayor;
        mayor.setMunicipality(this);
    }

    public void setProvince(Province province){
        this.province = province;
        this.province.addMunicipality(this);
    }
}