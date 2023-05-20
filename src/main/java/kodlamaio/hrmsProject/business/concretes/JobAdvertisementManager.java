package kodlamaio.hrmsProject.business.concretes;

import kodlamaio.hrmsProject.business.abstracts.JobAdvertisementService;
import kodlamaio.hrmsProject.business.requests.CreateJobAdvertisementRequest;
import kodlamaio.hrmsProject.business.responses.GetAllJobAdvertisementsResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrmsProject.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(CreateJobAdvertisementRequest createJobAdvertisementRequest) {
        JobAdvertisement jobAdvertisement = modelMapperService.forRequest().map(createJobAdvertisementRequest, JobAdvertisement.class);
        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("Job advertisement added.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAll() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findAll();

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                        modelMapperService.forResponse()
                                .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class)).toList();

        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Job advertisements listed.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisements() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByStatusTrue();

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                        modelMapperService.forResponse()
                                .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class)).toList();

        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Active Job advertisements listed.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisementsSortedByJobPostingDate() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByStatusTrueOrderByJobPostingDate();

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                        modelMapperService.forResponse()
                                .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class)).toList();

        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Active Job advertisements listed and sorted by job posting date.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveJobAdvertisementsAndCompanyNameIs(String companyName) {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByStatusTrueAndCompanyCompanyNameIs(companyName);

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                        modelMapperService.forResponse()
                                .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class)).toList();

        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Active Job advertisements listed for " + companyName);
    }

    @Override
    public Result setJobAdvertisementStatusFalse(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(jobAdvertisementId)
                .orElseThrow(() -> new IllegalArgumentException("Job advertisement not found with jobAdvertisementId: " + jobAdvertisementId));

        jobAdvertisement.setStatus(false);
        jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessResult("Job advertisement status has been set to false.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllActiveAndConfirmedJobAdvertisements() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.getAllActiveAndConfirmedJobAdvertisements();

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                        modelMapperService.forResponse().map(jobAdvertisement, GetAllJobAdvertisementsResponse.class)).toList();
        return new SuccessDataResult<>(getAllJobAdvertisementsResponses, "Active and confirmed Job advertisements listed.");
    }
}
