package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.Data;

@Entity
@Table(name = "job_seeker_web_addresses")
@Data
public class JobSeekerWebAddress {

    @Id
    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @OneToOne
    @MapsId
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
