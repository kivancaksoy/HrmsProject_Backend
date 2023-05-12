package kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.JobSeekerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage, Integer> {
    List<JobSeekerImage> findAllByJobSeekerId(int jobSeekerId);
}
