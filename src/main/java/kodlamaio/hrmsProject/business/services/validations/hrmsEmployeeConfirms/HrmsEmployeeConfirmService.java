package kodlamaio.hrmsProject.business.services.validations.hrmsEmployeeConfirms;

public interface HrmsEmployeeConfirmService {
    void confirmCompany(int hrmsEmployeeId, int companyId);
    void confirmJobAdvertisement(int hrmsEmployeeId, int jobAdvertisementId);
}
