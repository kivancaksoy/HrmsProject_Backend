package kodlamaio.hrmsProject.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllJobPositionsResponse {
    private int id;
    private String jobPositionName;
}
