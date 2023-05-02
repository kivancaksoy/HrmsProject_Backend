package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findByStatusTrue();
    List<JobAdvertisement> findByStatusTrueOrderByJobPostingDate();
    List<JobAdvertisement> findByStatusTrueAndCompanyCompanyNameIs(String companyName);

    // aşağıdaki işlemi manager sınıfında yaptık.
//    @Modifying
//    @Transactional
//    @Query("update JobAdvertisement j set j.status = false where j.id = :jobAdvertisementId")
//    void updateStatusById(int jobAdvertisementId);
}
