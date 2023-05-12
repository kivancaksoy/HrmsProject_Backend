package kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    List<Technology> findAllByJobSeekerId(int jobSeekerId);
}
