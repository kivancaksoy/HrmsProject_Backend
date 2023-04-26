package kodlamaio.hrmsProject.business.businessRules;

import kodlamaio.hrmsProject.business.requests.CreateJobSeeker;
import kodlamaio.hrmsProject.business.validations.emailVerification.EmailVerificationService;
import kodlamaio.hrmsProject.business.validations.mernisValidation.MernisValidationService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobSeekerBusinessRules {

    private JobSeekerDao jobSeekerDao;
    private UserDao userDao;
    private EmailVerificationService emailVerificationService;
    private MernisValidationService mernisValidationService;

    public Result isEmailVerified(String email) {
        boolean isVerified = emailVerificationService.isEmailApproved(email);
        if (isVerified)
            return new SuccessResult();
        return new ErrorResult("Email is not verified!");
    }

    public Result isPersonVerified (CreateJobSeeker createJobSeeker){
        boolean isVerified = mernisValidationService.checkIfRealPerson(createJobSeeker);

        if (isVerified)
            return new SuccessResult();
        return new ErrorResult("Mernis validation error!");
    }

    public Result emailCanNotBeDublicated(String email) {
        if (!userDao.existsByEmail(email))
            return new SuccessResult();
        return new ErrorResult("Email already exists!");
    }

    public Result tcknCanNotBeDublicated(String tckn) {
        if (!jobSeekerDao.existsByTckn(tckn))
            return new SuccessResult();
        return new ErrorResult("TCKN already exists!");
    }

}
