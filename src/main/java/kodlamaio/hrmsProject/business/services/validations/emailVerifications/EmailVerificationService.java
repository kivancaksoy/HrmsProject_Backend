package kodlamaio.hrmsProject.business.services.validations.emailVerifications;

import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;

public interface EmailVerificationService {
    void createEmailVerificationCodeCompany(Company company);
    void createEmailVerificationCodeJobSeeker(JobSeeker jobSeeker);

    void verifyEmail(int id, String code);
}
