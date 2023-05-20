package kodlamaio.hrmsProject.entities.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "employment_types")
public class EmploymentType {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "employment_type_name")
    private String employmentTypeName;

    @OneToMany(mappedBy = "employmentType")
    private List<JobAdvertisement> jobAdvertisements;
}
