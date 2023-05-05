package kodlamaio.hrmsProject.entities.concretes.appUsers;

import jakarta.persistence.*;
import kodlamaio.hrmsProject.entities.concretes.verifications.HrmsEmployeeConfirm;
import lombok.Data;

@Entity
@Data
@Table(name = "hrms_employees")
public class HrmsEmployee extends User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(mappedBy = "hrmsEmployee")
    private HrmsEmployeeConfirm hrmsEmployeeConfirm;

}
