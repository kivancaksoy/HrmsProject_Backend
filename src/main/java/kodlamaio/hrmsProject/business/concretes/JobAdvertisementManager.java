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
                                        .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class))
                        .toList();
        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Job advertisements listed.");
    }

    @Override
    public DataResult<List<GetAllJobAdvertisementsResponse>> getAllIsActive() {
        List<JobAdvertisement> jobAdvertisements = jobAdvertisementDao.findByIsActiveTrue();

        List<GetAllJobAdvertisementsResponse> getAllJobAdvertisementsResponses =
                jobAdvertisements.stream().map(jobAdvertisement ->
                                modelMapperService.forResponse()
                                        .map(jobAdvertisement, GetAllJobAdvertisementsResponse.class))
                        .toList();
        return new SuccessDataResult<List<GetAllJobAdvertisementsResponse>>(getAllJobAdvertisementsResponses, "Active Job advertisements listed.");
    }
}
