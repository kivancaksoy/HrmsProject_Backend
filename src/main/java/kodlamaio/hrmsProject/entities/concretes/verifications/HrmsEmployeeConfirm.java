package kodlamaio.hrmsProject.entities.concretes.verifications;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.appUsers.HrmsEmployee;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "hrms_employee_confirms")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class HrmsEmployeeConfirm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "confirm_date")
    private Date confirmDate;

    @OneToOne
    @JoinColumn(name = "hrms_employee_id")
    private HrmsEmployee hrmsEmployee;
}
