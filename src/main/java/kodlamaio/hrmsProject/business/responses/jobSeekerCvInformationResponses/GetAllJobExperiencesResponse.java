package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobExperiencesResponse {
    private int id;
    private int jobSeekerId;
    private String companyName;
    private String position;
    private Date startYear;
    private Date endYear;

    public Object getEndYear(){
        if (endYear == null)
            return "Devam ediyor.";
        return endYear;
    }

}
