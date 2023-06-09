package kodlamaio.hrmsProject.entities.concretes.appUsers;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirmCompany;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeCompany;
import lombok.Data;

import java.util.List;

/*@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Company {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "company")
    private List<JobAdvertisement> jobAdvertisements;

}*/

@Entity
@Table(name = "companies")
@Data
public class Company extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "company")
    private List<JobAdvertisement> jobAdvertisements;

    @OneToOne(mappedBy = "company")
    private EmailVerificationCodeCompany emailVerificationCodeCompany;

    @OneToOne(mappedBy = "company")
    private HrmsEmployeeConfirmCompany hrmsEmployeeConfirmCompany;

}
