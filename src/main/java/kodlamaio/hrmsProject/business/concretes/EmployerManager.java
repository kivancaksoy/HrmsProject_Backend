package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.EmployerService;
import kodlamaio.hrmsProject.business.businessRules.EmployersBusinessRules;
import kodlamaio.hrmsProject.business.requests.CreateEmployer;
import kodlamaio.hrmsProject.business.responses.GetAllEmployers;
import kodlamaio.hrmsProject.core.utilities.businessRules.BusinessRules;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.UserDao;
import kodlamaio.hrmsProject.entities.concretes.Employer;
import kodlamaio.hrmsProject.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserDao userDao;
    private ModelMapperService modelMapperService;
    private EmployersBusinessRules employersBusinessRules;

    @Override
    public Result add(CreateEmployer createEmployer) {

        var businessResult = BusinessRules.Run(employersBusinessRules.isEmailAndWebSiteOnTheSameDomain(createEmployer),
                employersBusinessRules.emailCanNotBeDublicated(createEmployer.getEmail()),
                employersBusinessRules.isEmailVerified(createEmployer.getEmail()));

        if (businessResult != null)
            return businessResult;

        User user = modelMapperService.forRequest().map(createEmployer, User.class);
        Employer employer = modelMapperService.forRequest().map(createEmployer, Employer.class);

        User createdUser = userDao.save(user);
        employer.setEmployerId(createdUser.getId());
        employerDao.save(employer);

        return new SuccessResult("Employer created.");
    }

    @Override
    public DataResult<List<GetAllEmployers>> getAll() {
        List<Employer> employers = employerDao.findAll();

        List<GetAllEmployers> getAllEmployers =
                employers.stream().map(employer ->
                        modelMapperService.forResponse()
                                .map(employer, GetAllEmployers.class)).toList();
        return new SuccessDataResult<>(getAllEmployers, "Employers listed.");

    }
}
