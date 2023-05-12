package kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.enums.StorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobSeekerImagesResponse {
    private int id;
    private int jobSeekerId;
    private String imageName;
    private String imagePath;
    private StorageType storageName;
}
