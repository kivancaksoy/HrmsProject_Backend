package kodlamaio.hrmsProject.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobAdvertisementRequest {
    @NotNull
    private int companyId;

    @NotNull
    private int jobPositionId;

    @Size(min = 2)
    private String description;

    private Integer minSalary;

    private Integer maxSalary;

    @NotNull
    private int numberOfJobOpenings;

    @NotNull
    private Date applicationDeadline;

    @NotNull
    private Date jobPostingDate;

    private boolean isActive = true;

    @NotNull
    private int cityId;
}
