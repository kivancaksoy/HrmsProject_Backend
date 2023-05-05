package kodlamaio.hrmsProject.business.validations.emailVerification;

import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;

import java.util.UUID;

public interface EmailVerificationService {
    void createEmailVerificationCodeCompany(Company company);
    void createEmailVerificationCodeJobSeeker(JobSeeker jobSeeker);

    void verifyEmail(int id, String code);
}
