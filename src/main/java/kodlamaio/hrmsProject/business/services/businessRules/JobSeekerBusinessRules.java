package kodlamaio.hrmsProject.business.services.businessRules;

import kodlamaio.hrmsProject.business.requests.CreateJobSeekerRequest;
import kodlamaio.hrmsProject.business.services.validations.personValidations.PersonValidationService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.EmailVerificationCodeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerBusinessRules {

    private final JobSeekerDao jobSeekerDao;
    private final UserDao userDao;
    private final EmailVerificationCodeDao emailVerificationCodeDao;
    private final PersonValidationService personValidationService;

    public JobSeekerBusinessRules(JobSeekerDao jobSeekerDao, UserDao userDao, EmailVerificationCodeDao emailVerificationCodeDao, PersonValidationService personValidationService) {
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
        this.emailVerificationCodeDao = emailVerificationCodeDao;
        this.personValidationService = personValidationService;
    }


    public Result isPersonVerified(CreateJobSeekerRequest createJobSeekerRequest) {
        boolean isVerified = personValidationService.checkIfRealPerson(createJobSeekerRequest);

        if (isVerified)
            return new SuccessResult();
        return new ErrorResult("Mernis validation error!");
    }

    public Result emailCanNotBeDuplicated(String email) {
        if (!userDao.existsByEmail(email))
            return new SuccessResult();
        return new ErrorResult("Email already exists!");
    }

    public Result CanCanCanNotBeDuplicated(String tckn) {
        if (!jobSeekerDao.existsByTckn(tckn))
            return new SuccessResult();
        return new ErrorResult("TCKN already exists!");
    }

}
