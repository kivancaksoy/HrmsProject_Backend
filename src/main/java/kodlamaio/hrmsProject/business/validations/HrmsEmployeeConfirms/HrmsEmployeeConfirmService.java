package kodlamaio.hrmsProject.business.validations.HrmsEmployeeConfirms;

import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.HrmsEmployee;

import java.util.List;

public interface HrmsEmployeeConfirmService {
    void confirmCompany(int hrmsEmployeeId, int companyId);
}
