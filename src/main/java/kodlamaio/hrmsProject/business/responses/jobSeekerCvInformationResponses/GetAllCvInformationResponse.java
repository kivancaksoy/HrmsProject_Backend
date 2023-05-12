package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCvInformationResponse {
    private int jobSeekerId;
    private GetCoverLetterResponse coverLetter;
    private List<GetAllJobExperiencesResponse> jobExperiences;
    private List<GetAllJobSeekerImagesResponse> jobSeekerImages;
    private GetJobSeekerWebAddressResponse jobSeekerWebAddress;
    private List<GetAllLanguagesResponse> languages;
    private List<GetAllSchoolsResponse> schools;
    private List<GetAllTechnologiesResponse> technologies;
}
