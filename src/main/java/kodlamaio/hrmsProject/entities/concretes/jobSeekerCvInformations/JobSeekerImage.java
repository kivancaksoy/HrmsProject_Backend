package kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.enums.StorageType;
import lombok.Data;

@Entity
@Table(name = "job_seeker_images")
@Data
public class JobSeekerImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "storage_name")
    @Enumerated(EnumType.STRING)
    private StorageType storageName;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
