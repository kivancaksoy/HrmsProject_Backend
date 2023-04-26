package kodlamaio.hrmsProject.business.businessRules;

import kodlamaio.hrmsProject.core.utilities.results.ErrorResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobPositionDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobPositonBusinessRules {
    private JobPositionDao jobPositionDao;

    public Result doesJobPositionNameExist(String jobPositionName) {
        if (!jobPositionDao.existsByJobPositionName(jobPositionName)) {
            return new SuccessResult();
        }
        return new ErrorResult("Job position name already exists!");
    }
}
