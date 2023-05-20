package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirmJobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeConfirmJobAdvertisementDao extends JpaRepository<HrmsEmployeeConfirmJobAdvertisement, Integer> {
}
