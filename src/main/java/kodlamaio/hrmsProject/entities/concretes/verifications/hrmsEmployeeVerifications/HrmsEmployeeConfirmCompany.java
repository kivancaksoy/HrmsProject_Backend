package kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirm;
import lombok.Data;

@Entity
@Table(name = "hrms_employee_confirm_companies")
@Data
public class HrmsEmployeeConfirmCompany extends HrmsEmployeeConfirm {
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
