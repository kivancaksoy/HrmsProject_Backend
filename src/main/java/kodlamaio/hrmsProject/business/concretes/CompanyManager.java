package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.CompanyService;
import kodlamaio.hrmsProject.business.services.businessRules.CompaniesBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateCompanyRequest;
import kodlamaio.hrmsProject.business.responses.GetAllCompaniesResponse;
import kodlamaio.hrmsProject.business.services.validations.emailVerifications.EmailVerificationService;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.*;
import kodlamaio.hrmsProject.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {

    private final CompanyDao companyDao;
    private final ModelMapperService modelMapperService;
    private final CompaniesBusinessRules companiesBusinessRules;
    private final EmailVerificationService emailVerificationService;

    public CompanyManager(CompanyDao companyDao, ModelMapperService modelMapperService, CompaniesBusinessRules companiesBusinessRules, EmailVerificationService emailVerificationService) {
        this.companyDao = companyDao;
        this.modelMapperService = modelMapperService;
        this.companiesBusinessRules = companiesBusinessRules;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public Result add(CreateCompanyRequest createCompanyRequest) {

        var businessResult = BusinessRules.Run(companiesBusinessRules.isEmailAndWebSiteOnTheSameDomain(createCompanyRequest),
                companiesBusinessRules.emailCanNotBeDuplicated(createCompanyRequest.getEmail()));

        if (businessResult != null)
            return businessResult;

        Company company = modelMapperService.forRequest().map(createCompanyRequest, Company.class);
        Company createdCompany = companyDao.save(company);

        emailVerificationService.createEmailVerificationCodeCompany(createdCompany);
        return new SuccessResult("An email has been sent, please check your email.");
    }

    @Override
    public DataResult<List<GetAllCompaniesResponse>> getAll() {
        //List<Company> companies = companyDao.findAll();
        List<Company> companies = companyDao.getAllActiveCompanies();

        List<GetAllCompaniesResponse> getAllCompaniesResponses =
                companies.stream().map(company ->
                        modelMapperService.forResponse()
                                .map(company, GetAllCompaniesResponse.class)).toList();
        return new SuccessDataResult<>(getAllCompaniesResponses, "Companies listed.");

    }
}
