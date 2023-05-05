package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company, Integer> {
    @Query("From Company c Inner Join c.emailVerificationCodeCompany ec Inner Join c.hrmsEmployeeConfirmCompany he where ec.isVerified = true and he.isConfirmed = true ")
    List<Company> getAllActiveCompanies();
}
