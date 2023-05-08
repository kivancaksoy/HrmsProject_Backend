package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.Data;

@Entity
@Table(name = "cover_letters")
@Data
public class CoverLetter {
    @Id
    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToOne
    @MapsId
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
