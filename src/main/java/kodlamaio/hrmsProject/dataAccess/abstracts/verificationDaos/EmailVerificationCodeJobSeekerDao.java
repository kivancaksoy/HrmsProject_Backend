package kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos;

import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeJobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationCodeJobSeekerDao extends JpaRepository<EmailVerificationCodeJobSeeker, Integer> {
}
