package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.HrmsEmployeeConfirmCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeConfirmCompanyDao extends JpaRepository<HrmsEmployeeConfirmCompany, Integer> {
}
