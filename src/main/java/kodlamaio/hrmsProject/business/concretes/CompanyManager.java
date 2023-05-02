package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.CompanyService;
import kodlamaio.hrmsProject.business.businessRules.CompaniesBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateCompanyRequest;
import kodlamaio.hrmsProject.business.responses.GetAllCompaniesResponse;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.*;
import kodlamaio.hrmsProject.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import kodlamaio.hrmsProject.entities.concretes.Company;
import kodlamaio.hrmsProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {

    private CompanyDao companyDao;
    private UserDao userDao;
    private ModelMapperService modelMapperService;
    private CompaniesBusinessRules companiesBusinessRules;

    @Override
    public Result add(CreateCompanyRequest createCompanyRequest) {

        var businessResult = BusinessRules.Run(companiesBusinessRules.isEmailAndWebSiteOnTheSameDomain(createCompanyRequest),
                companiesBusinessRules.emailCanNotBeDublicated(createCompanyRequest.getEmail()),
                companiesBusinessRules.isEmailVerified(createCompanyRequest.getEmail()));

        if (businessResult != null)
            return businessResult;

        User user = modelMapperService.forRequest().map(createCompanyRequest, User.class);
        Company company = modelMapperService.forRequest().map(createCompanyRequest, Company.class);

        User createdUser = userDao.save(user);
        company.setUser(createdUser);
        companyDao.save(company);


        return new SuccessResult("Company created.");
    }

    @Override
    public DataResult<List<GetAllCompaniesResponse>> getAll() {
        List<Company> companies = companyDao.findAll();

        List<GetAllCompaniesResponse> getAllCompaniesResponses =
                companies.stream().map(company ->
                        modelMapperService.forResponse()
                                .map(company, GetAllCompaniesResponse.class)).toList();
        return new SuccessDataResult<>(getAllCompaniesResponses, "Companies listed.");

    }
}
