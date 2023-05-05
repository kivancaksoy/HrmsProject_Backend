package kodlamaio.hrmsProject.business.validations.HrmsEmployeeConfirms;

import kodlamaio.hrmsProject.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.HrmsEmployeeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.HrmsEmployeeConfirmCompanyDao;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.HrmsEmployee;
import kodlamaio.hrmsProject.entities.concretes.verifications.HrmsEmployeeConfirmCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HrmsEmployeeConfirmManager implements HrmsEmployeeConfirmService {
    private final HrmsEmployeeConfirmCompanyDao hrmsEmployeeConfirmCompanyDao;
    private CompanyDao companyDao;
    private HrmsEmployeeDao hrmsEmployeeDao;

    @Autowired
    public HrmsEmployeeConfirmManager(HrmsEmployeeConfirmCompanyDao hrmsEmployeeConfirmCompanyDao, CompanyDao companyDao, HrmsEmployeeDao hrmsEmployeeDao) {
        this.hrmsEmployeeConfirmCompanyDao = hrmsEmployeeConfirmCompanyDao;
        this.companyDao = companyDao;
        this.hrmsEmployeeDao = hrmsEmployeeDao;
    }

    @Override
    public void confirmCompany(int hrmsEmployeeId, int companyId) {
        HrmsEmployeeConfirmCompany hrmsEmployeeConfirmCompany = new HrmsEmployeeConfirmCompany();

        HrmsEmployee hrmsEmployee = hrmsEmployeeDao.findById(hrmsEmployeeId).orElseThrow();
        Company company = companyDao.findById(companyId).orElseThrow();

        hrmsEmployeeConfirmCompany.setConfirmed(true);
        hrmsEmployeeConfirmCompany.setConfirmDate(new Date());
        hrmsEmployeeConfirmCompany.setHrmsEmployee(hrmsEmployee);
        hrmsEmployeeConfirmCompany.setCompany(company);

        hrmsEmployeeConfirmCompanyDao.save(hrmsEmployeeConfirmCompany);
    }
}
