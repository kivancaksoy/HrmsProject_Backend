package kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
