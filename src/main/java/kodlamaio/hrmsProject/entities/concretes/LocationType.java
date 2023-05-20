package kodlamaio.hrmsProject.entities.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "location_types")
public class LocationType {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "location_type_name")
    private String locationTypeName;

    @OneToMany(mappedBy = "locationType")
    private List<JobAdvertisement> jobAdvertisements;

}
