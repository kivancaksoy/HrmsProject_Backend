package kodlamaio.hrmsProject.business.services.businessRules;

import kodlamaio.hrmsProject.business.requests.CreateCompanyRequest;
import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.EmailVerificationCodeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import org.springframework.stereotype.Service;

@Service
public class CompaniesBusinessRules {

    private final UserDao userDao;

    public CompaniesBusinessRules(UserDao userDao) {
        this.userDao = userDao;
    }

    public Result isEmailAndWebSiteOnTheSameDomain(CreateCompanyRequest createCompanyRequest) {
        int getWebSiteDomainStartingIndex = createCompanyRequest.getWebSite().indexOf(".") + 1;
        String getWebSiteDomain = createCompanyRequest.getWebSite().substring(getWebSiteDomainStartingIndex);

        int getEmailDomainStartingIndex = createCompanyRequest.getEmail().indexOf("@") + 1;
        String getEmailDomain = createCompanyRequest.getEmail().substring(getEmailDomainStartingIndex);

        if (getWebSiteDomain.equals(getEmailDomain))
            return new SuccessResult();
        return new ErrorResult("Website and email are not on the same domain!");
    }


    public Result emailCanNotBeDuplicated(String email) {
        if (!userDao.existsByEmail(email))
            return new SuccessResult();
        return new ErrorResult("Email already exists!");
    }

}
