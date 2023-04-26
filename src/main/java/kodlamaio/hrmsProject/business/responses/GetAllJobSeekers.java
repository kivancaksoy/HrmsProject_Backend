package kodlamaio.hrmsProject.business.responses;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobSeekers {
    private int jobSeekerId;
    private String email;
    private String firstName;
    private String lastName;
    private String tckn;
    private Date birthDate;
}