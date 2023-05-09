package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "language_level")
    private int languageLevel;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
