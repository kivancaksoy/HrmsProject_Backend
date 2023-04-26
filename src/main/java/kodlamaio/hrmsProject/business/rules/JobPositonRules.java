package kodlamaio.hrmsProject.business.rules;

import kodlamaio.hrmsProject.dataAccess.abstracts.JobPositionDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobPositonRules {
    private JobPositionDao jobPositionDao;

    public boolean doesJobPositionNameExist(String jobPositionName) {
        boolean result = jobPositionDao.existsByJobPositionName(jobPositionName);
        if (!result) {
            return false;
        }
        return true;
    }
}
