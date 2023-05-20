package kodlamaio.hrmsProject.entities.concretes.verifications.hrmsEmployeeVerifications;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import lombok.Data;

@Entity
@Data
@Table(name = "hrms_employee_confirm_job_advertisements")
public class HrmsEmployeeConfirmJobAdvertisement extends HrmsEmployeeConfirm{
    @OneToOne
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;
}
