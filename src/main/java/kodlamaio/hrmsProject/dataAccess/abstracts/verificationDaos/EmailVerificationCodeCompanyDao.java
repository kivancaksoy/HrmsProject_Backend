package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationCodeCompanyDao extends JpaRepository<EmailVerificationCodeCompany, Integer> {
}
