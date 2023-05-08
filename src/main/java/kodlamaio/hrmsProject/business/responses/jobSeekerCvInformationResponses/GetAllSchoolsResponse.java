package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSchoolsResponse {
    private int id;
    private int jobSeekerId;
    private String schoolName;
    private String department;
    private int startYear;
    private Integer graduatedYear;

    public Object getGraduatedYear(){
        if (graduatedYear == null)
            return "Devam ediyor.";
        return graduatedYear;
    }
}
