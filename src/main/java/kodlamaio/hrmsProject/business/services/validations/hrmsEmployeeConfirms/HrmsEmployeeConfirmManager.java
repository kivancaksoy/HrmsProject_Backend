package kodlamaio.hrmsProject.business.services.validations.hrmsEmployeeConfirms;

import kodlamaio.hrmsProject.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.HrmsEmployeeDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.HrmsEmployeeConfirmCompanyDao;
import kodlamaio.hrmsProject.dataAccess.abstracts.verificationDaos.HrmsEmployeeConfirmJobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import kodlamaio.hrmsProject.entities.concretes.appUsers.HrmsEmployee;
import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirmCompany;
import kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications.HrmsEmployeeConfirmJobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HrmsEmployeeConfirmManager implements HrmsEmployeeConfirmService {
    private final HrmsEmployeeConfirmCompanyDao hrmsEmployeeConfirmCompanyDao;
    private final CompanyDao companyDao;
    private final HrmsEmployeeDao hrmsEmployeeDao;
    private final JobAdvertisementDao jobAdvertisementDao;
    private final HrmsEmployeeConfirmJobAdvertisementDao hrmsEmployeeConfirmJobAdvertisementDao;

    @Autowired
    public HrmsEmployeeConfirmManager(HrmsEmployeeConfirmCompanyDao hrmsEmployeeConfirmCompanyDao, CompanyDao companyDao, HrmsEmployeeDao hrmsEmployeeDao, JobAdvertisementDao jobAdvertisementDao, HrmsEmployeeConfirmJobAdvertisementDao hrmsEmployeeConfirmJobAdvertisementDao) {
        this.hrmsEmployeeConfirmCompanyDao = hrmsEmployeeConfirmCompanyDao;
        this.companyDao = companyDao;
        this.hrmsEmployeeDao = hrmsEmployeeDao;
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.hrmsEmployeeConfirmJobAdvertisementDao = hrmsEmployeeConfirmJobAdvertisementDao;
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

    @Override
    public void confirmJobAdvertisement(int hrmsEmployeeId, int jobAdvertisementId) {
        HrmsEmployeeConfirmJobAdvertisement hrmsEmployeeConfirmJobAdvertisement = new HrmsEmployeeConfirmJobAdvertisement();

        HrmsEmployee hrmsEmployee = hrmsEmployeeDao.findById(hrmsEmployeeId).orElseThrow();
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(jobAdvertisementId).orElseThrow();

        hrmsEmployeeConfirmJobAdvertisement.setConfirmed(true);
        hrmsEmployeeConfirmJobAdvertisement.setConfirmDate(new Date());
        hrmsEmployeeConfirmJobAdvertisement.setHrmsEmployee(hrmsEmployee);
        hrmsEmployeeConfirmJobAdvertisement.setJobAdvertisement(jobAdvertisement);

        hrmsEmployeeConfirmJobAdvertisementDao.save(hrmsEmployeeConfirmJobAdvertisement);
    }
}
