package kodlamaio.hrmsProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobAdvertisementsResponse {
    private int id;
    private int numberOfJobOpenings;
    private Date applicationDeadline;
    private Date jobPostingDate;
    private String companyName;
    private String jobPositionName;

}
