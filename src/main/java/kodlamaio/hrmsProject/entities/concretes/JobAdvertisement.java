package kodlamaio.hrmsProject.entities.concretes;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirmJobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;

    @Column(name = "number_of_job_openings")
    private int numberOfJobOpenings;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "job_posting_date")
    private Date jobPostingDate;

    @Column(name = "status")
    private boolean status;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @ManyToOne()
    @JoinColumn(name = "location_type_id")
    private LocationType locationType;

    @OneToOne(mappedBy = "jobAdvertisement")
    private HrmsEmployeeConfirmJobAdvertisement hrmsEmployeeConfirmJobAdvertisement;

}
