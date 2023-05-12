package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "job_seeker_web_addresses")
@Getter
@Setter
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
    private JobSeeker jobSeeker;
}
