package kodlamaio.hrmsProject.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "job_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPosition {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "position_name")
    private String positionName;
}
