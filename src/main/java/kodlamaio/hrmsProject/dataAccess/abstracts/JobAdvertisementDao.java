package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findByStatusTrue();
    List<JobAdvertisement> findByStatusTrueOrderByJobPostingDate();
    List<JobAdvertisement> findByStatusTrueAndCompanyCompanyNameIs(String companyName);

    @Query("From JobAdvertisement j Inner Join j.hrmsEmployeeConfirmJobAdvertisement he where he.isConfirmed = true and j.status = true")
    List<JobAdvertisement> getAllActiveAndConfirmedJobAdvertisements();

    // aşağıdaki işlemi manager sınıfında yaptık.
//    @Modifying
//    @Transactional
//    @Query("update JobAdvertisement j set j.status = false where j.id = :jobAdvertisementId")
//    void updateStatusById(int jobAdvertisementId);
}
