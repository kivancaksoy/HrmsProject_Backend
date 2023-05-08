package kodlamaio.hrmsProject.entities.concretes.appUsers;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.*;
import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeJobSeeker;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/*@Entity
@Table(name = "job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_user_id", referencedColumnName = "id")
    private User user;
}*/
@Entity
@Table(name = "job_seekers")
@Data
public class JobSeeker extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "birth_date")
    private Date birthDate;

    //email verification control
    @OneToOne(mappedBy = "jobSeeker")
    private EmailVerificationCodeJobSeeker emailVerificationCodeJobSeeker;

    //CV informations
    @OneToOne(mappedBy = "jobSeeker")
    private CoverLetter coverLetter;

    @OneToMany(mappedBy = "jobSeeker")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "jobSeeker")
    private List<JobSeekerImage> jobSeekerImages;

    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerWebAddress jobSeekerWebAddress;

    @OneToMany(mappedBy = "jobSeeker")
    private List<Language> languages;

    @OneToMany(mappedBy = "jobSeeker")
    private List<School> schools;

    @OneToMany(mappedBy = "jobSeeker")
    private List<Technology> technologies;
}
