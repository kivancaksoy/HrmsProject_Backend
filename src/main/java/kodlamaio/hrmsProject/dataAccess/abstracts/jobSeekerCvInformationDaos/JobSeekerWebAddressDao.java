package kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.JobSeekerWebAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerWebAddressDao extends JpaRepository<JobSeekerWebAddress, Integer> {
}
