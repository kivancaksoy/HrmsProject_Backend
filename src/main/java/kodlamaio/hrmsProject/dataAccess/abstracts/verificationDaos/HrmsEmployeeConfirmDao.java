package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeConfirmDao extends JpaRepository<HrmsEmployeeConfirm, Integer> {
}
