package kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.Company;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "email_verification_code_companies")
@Data
public class EmailVerificationCodeCompany extends EmailVerificationCode {
    @OneToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;
}
