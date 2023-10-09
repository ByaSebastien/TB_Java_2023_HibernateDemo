package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor
@ToString(of = {"id","name"}) @EqualsAndHashCode(of = {"id","name"})
public class Province {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "province")
    @OrderBy("name")
    private List<Municipality> municipalities = new ArrayList<>();

    public void addMunicipality(Municipality municipality){

        this.municipalities.add(municipality);
    }

    public void removeMunicipality(Municipality municipality){

        this.municipalities.remove(municipality);
    }

    public List<Municipality> getMunicipalities(){

        return List.copyOf(municipalities);
    }














}
