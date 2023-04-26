package kodlamaio.hrmsProject.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobPosition {
    private int id;
    private String positionName;
}
