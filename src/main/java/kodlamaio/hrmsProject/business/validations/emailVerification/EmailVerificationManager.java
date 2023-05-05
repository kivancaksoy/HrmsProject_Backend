package kodlamaio.hrmsProject.business.validations.emailVerification;


import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.EmailVerificationCodeCompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.EmailVerificationCodeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.EmailVerificationCodeJobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCode;
import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeCompany;
import kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications.EmailVerificationCodeJobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    private final EmailVerificationCodeCompanyDao emailVerificationCodeCompanyDao;
    private final EmailVerificationCodeJobSeekerDao emailVerificationCodeJobSeekerDao;
    private final EmailVerificationCodeDao emailVerificationCodeDao;

    @Autowired
    public EmailVerificationManager(EmailVerificationCodeCompanyDao emailVerificationCodeCompanyDao, EmailVerificationCodeJobSeekerDao emailVerificationCodeJobSeekerDao, EmailVerificationCodeDao emailVerificationCodeDao) {
        this.emailVerificationCodeCompanyDao = emailVerificationCodeCompanyDao;
        this.emailVerificationCodeJobSeekerDao = emailVerificationCodeJobSeekerDao;
        this.emailVerificationCodeDao = emailVerificationCodeDao;
    }

    @Override
    public void createEmailVerificationCodeCompany(Company company) {
        String createdCode = createEmailVerificationCode();
        EmailVerificationCodeCompany emailVerificationCodeCompany = new EmailVerificationCodeCompany();

        emailVerificationCodeCompany.setCode(createdCode);
        emailVerificationCodeCompany.setCompany(company);
        emailVerificationCodeCompanyDao.save(emailVerificationCodeCompany);
    }

    @Override
    public void createEmailVerificationCodeJobSeeker(JobSeeker jobSeeker) {
        String createdCode = createEmailVerificationCode();
        EmailVerificationCodeJobSeeker emailVerificationCodeJobSeeker = new EmailVerificationCodeJobSeeker();

        emailVerificationCodeJobSeeker.setCode(createdCode);
        emailVerificationCodeJobSeeker.setJobSeeker(jobSeeker);
        emailVerificationCodeJobSeekerDao.save(emailVerificationCodeJobSeeker);
    }

    @Override
    public void verifyEmail(int id, String code) {
        EmailVerificationCode emailVerificationCode = emailVerificationCodeDao.findById(id).orElseThrow();
        if (code.equals(emailVerificationCode.getCode())){
            emailVerificationCode.setVerified(true);
            emailVerificationCode.setVerifiedDate(new Date());
            emailVerificationCodeDao.save(emailVerificationCode);
        }

    }

    private String createEmailVerificationCode() {
        String emailVerificationCode = UUID.randomUUID().toString();
        return emailVerificationCode;
    }
}
