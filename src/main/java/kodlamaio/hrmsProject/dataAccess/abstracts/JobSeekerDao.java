package kodlamaio.hrmsProject.dataAccess.abstracts;

import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    boolean existsByTckn(String tckn);

    @Query("From JobSeeker j Inner Join j.emailVerificationCodeJobSeeker ej where ej.isVerified = true")
    List<JobSeeker> getAllActiveJobSeekers();
}
