package kodlamaio.hrmsProject.business.validations.emailVerification;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerificationService {
    @Override
    public boolean isEmailApproved(String email) {
        return true;
    }
}
