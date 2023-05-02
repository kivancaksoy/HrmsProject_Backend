package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.business.responses.GetAllJobAdvertisementsResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findByIsActiveTrue();
}
