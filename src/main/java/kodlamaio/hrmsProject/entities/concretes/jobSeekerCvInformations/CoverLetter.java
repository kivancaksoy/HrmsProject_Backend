package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cover_letters")
@Getter
@Setter
public class CoverLetter {
    @Id
    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "cover_letter")
    private String coverLetter;

    @OneToOne
    @MapsId
    //@JoinColumn(name = "job_seeker_id") //OneToOne'da ortak Id kolonu kullanılıyorsa, JoinColumn kapatmak gerekiyor
    //yoksa null identifier hatası alınıyor.
    private JobSeeker jobSeeker;
}
