package kodlamaio.hrmsProject.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

    @Id
    @Column(name = "job_seeker_id")
    private int jobSeekerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "job_seeker_id", referencedColumnName = "id")
    private User user;
}
