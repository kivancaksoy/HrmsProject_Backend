package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationCodeDao extends JpaRepository<EmailVerificationCode, Integer> {
}
