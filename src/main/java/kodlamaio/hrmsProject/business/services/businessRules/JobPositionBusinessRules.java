package kodlamaio.hrmsProject.business.services.businessRules;

import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobPositionDao;
import org.springframework.stereotype.Service;

@Service
public class JobPositionBusinessRules {
    private final JobPositionDao jobPositionDao;

    public JobPositionBusinessRules(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    public Result doesJobPositionNameExist(String jobPositionName) {
        if (!jobPositionDao.existsByJobPositionName(jobPositionName)) {
            return new SuccessResult();
        }
        return new ErrorResult("Job position name already exists!");
    }
}
