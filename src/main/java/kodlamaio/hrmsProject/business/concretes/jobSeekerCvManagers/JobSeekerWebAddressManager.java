package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.JobSeekerWebAddressService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateJobSeekerWebAddressRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetJobSeekerWebAddressResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.JobSeekerWebAddressDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.JobSeekerWebAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerWebAddressManager implements JobSeekerWebAddressService {
    private final JobSeekerWebAddressDao jobSeekerWebAddressDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public JobSeekerWebAddressManager(JobSeekerWebAddressDao jobSeekerWebAddressDao, ModelMapperService modelMapperService) {
        this.jobSeekerWebAddressDao = jobSeekerWebAddressDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateJobSeekerWebAddressRequest createJobSeekerWebAddressRequest) {
        JobSeekerWebAddress jobSeekerWebAddress =
                modelMapperService.forRequest().map(createJobSeekerWebAddressRequest, JobSeekerWebAddress.class);
        jobSeekerWebAddress.setJobSeekerId(createJobSeekerWebAddressRequest.getJobSeekerId());
        jobSeekerWebAddressDao.save(jobSeekerWebAddress);

        return new SuccessResult("Web adresses added.");
    }

    @Override
    public DataResult<GetJobSeekerWebAddressResponse> getJobSeekerWebAddressResponse(int jobSeekerId) {
        JobSeekerWebAddress jobSeekerWebAddress = jobSeekerWebAddressDao.findById(jobSeekerId).orElseThrow();

        // model mapper kullanınca jobSeekerId'yi setlemiyor.
//        GetJobSeekerWebAddressResponse getJobSeekerWebAddressResponse =
//                modelMapperService.forResponse().map(jobSeekerWebAddress, GetJobSeekerWebAddressResponse.class);
        GetJobSeekerWebAddressResponse getJobSeekerWebAddressResponse = new GetJobSeekerWebAddressResponse();
        getJobSeekerWebAddressResponse.setJobSeekerId(jobSeekerWebAddress.getJobSeekerId());
        getJobSeekerWebAddressResponse.setGithubAddress(jobSeekerWebAddress.getGithubAddress());
        getJobSeekerWebAddressResponse.setLinkedinAddress(jobSeekerWebAddress.getLinkedinAddress());
        return new SuccessDataResult<>(getJobSeekerWebAddressResponse);
    }
}
