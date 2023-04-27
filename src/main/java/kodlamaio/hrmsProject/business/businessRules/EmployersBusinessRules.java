package kodlamaio.hrmsProject.business.businessRules;

import kodlamaio.hrmsProject.business.requests.CreateEmployerRequest;
import kodlamaio.hrmsProject.business.validations.emailVerification.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployersBusinessRules {

    private EmployerDao employerDao;
    private UserDao userDao;
    private EmailVerificationService emailVerificationService;

    public Result isEmailAndWebSiteOnTheSameDomain(CreateEmployerRequest createEmployerRequest) {
        int getWebSiteDomainStartingIndex = createEmployerRequest.getWebSite().indexOf(".") + 1;
        String getWebSiteDomain = createEmployerRequest.getWebSite().substring(getWebSiteDomainStartingIndex);

        int getEmailDomainStartingIndex = createEmployerRequest.getEmail().indexOf("@") + 1;
        String getEmailDomain = createEmployerRequest.getEmail().substring(getEmailDomainStartingIndex);

        if (getWebSiteDomain.equals(getEmailDomain))
            return new SuccessResult();
        return new ErrorResult("Website and email are not on the same domain!");
    }

    public Result isEmailVerified(String email) {
        boolean isVerified = emailVerificationService.isEmailApproved(email);
        if (isVerified)
            return new SuccessResult();
        return new ErrorResult("Email is not verified!");
    }

    public Result emailCanNotBeDublicated(String email) {
        if (!userDao.existsByEmail(email))
            return new SuccessResult();
        return new ErrorResult("Email already exists!");
    }
}
