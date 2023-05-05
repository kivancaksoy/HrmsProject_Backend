package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.appUsers.HrmsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeDao extends JpaRepository<HrmsEmployee, Integer> {
}
