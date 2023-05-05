package kodlamaio.hrmsProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCompaniesResponse {
    private int id;
    private String email;
    private String companyName;
    private String webSite;
    private String phoneNumber;
}
