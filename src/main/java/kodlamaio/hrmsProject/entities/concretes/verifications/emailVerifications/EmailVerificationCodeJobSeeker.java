package kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.*;

@Entity
@Table(name = "email_verification_code_job_seekers")
@Data
public class EmailVerificationCodeJobSeeker extends EmailVerificationCode {

    @OneToOne
    @JoinColumn(name = "job_seeker_id")
    @ToString.Exclude
    private JobSeeker jobSeeker;
}
