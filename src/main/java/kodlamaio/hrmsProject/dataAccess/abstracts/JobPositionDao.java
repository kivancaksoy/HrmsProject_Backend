package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    boolean existsByJobPositionName(String jobPositionName);
}
