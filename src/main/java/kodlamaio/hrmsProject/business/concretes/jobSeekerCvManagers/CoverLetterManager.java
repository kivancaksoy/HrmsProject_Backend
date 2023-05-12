package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.CoverLetterService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateCoverLetterRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetCoverLetterResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.CoverLetterDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverLetterManager implements CoverLetterService {
    private final CoverLetterDao coverLetterDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao, ModelMapperService modelMapperService) {
        this.coverLetterDao = coverLetterDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateCoverLetterRequest createCoverLetterRequest) {
        CoverLetter coverLetter = modelMapperService.forRequest().map(createCoverLetterRequest, CoverLetter.class);
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Cover letter added.");
    }

    @Override
    public DataResult<GetCoverLetterResponse> getCoverLetterByJobSeekerId(int jobSeekerId) {
        CoverLetter coverLetter = coverLetterDao.findById(jobSeekerId).orElseThrow();

        GetCoverLetterResponse getCoverLetterResponse = new GetCoverLetterResponse();
        getCoverLetterResponse.setJobSeekerId(coverLetter.getJobSeekerId());
        getCoverLetterResponse.setCoverLetter(coverLetter.getCoverLetter());

        return new SuccessDataResult<>(getCoverLetterResponse);
    }
}
