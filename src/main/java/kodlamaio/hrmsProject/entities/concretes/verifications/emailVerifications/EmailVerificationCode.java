package kodlamaio.hrmsProject.entities.concretes.verifications.emailVerifications;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "email_verification_codes")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class EmailVerificationCode {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "is_verified")
    private boolean isVerified = false;

    @Column(name = "verified_date")
    private Date verifiedDate;

}
