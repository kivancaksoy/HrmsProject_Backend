package kodlamaio.hrmsProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployersResponse {
    private int employerId;
    private String email;
    private String companyName;
    private String webSite;
    private String phoneNumber;
}
