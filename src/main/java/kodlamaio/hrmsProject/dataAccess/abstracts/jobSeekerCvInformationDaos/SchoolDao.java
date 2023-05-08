package kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {
    List<School> findAllByOrderByGraduatedYearDesc();
}
