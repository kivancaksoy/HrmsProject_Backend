package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {
}
