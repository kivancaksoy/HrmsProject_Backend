package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.*;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllCvInformationResponse;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrmsProject.entities.concretes.appUsers.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class CvInformationManager implements CvInformationService {
    private final JobSeekerDao jobSeekerDao;
    private final JobExperienceService jobExperienceService;
    private final JobSeekerImageService jobSeekerImageService;
    private final LanguageService languageService;
    private final SchoolService schoolService;
    private final TechnologyService technologyService;
    private final CoverLetterService coverLetterService;
    private final JobSeekerWebAddressService jobSeekerWebAddressService;

    public CvInformationManager(JobSeekerDao jobSeekerDao, JobExperienceService jobExperienceService, JobSeekerImageService jobSeekerImageService, LanguageService languageService, SchoolService schoolService, TechnologyService technologyService, CoverLetterService coverLetterService, JobSeekerWebAddressService jobSeekerWebAddressService) {
        this.jobSeekerDao = jobSeekerDao;
        this.jobExperienceService = jobExperienceService;
        this.jobSeekerImageService = jobSeekerImageService;
        this.languageService = languageService;
        this.schoolService = schoolService;
        this.technologyService = technologyService;
        this.coverLetterService = coverLetterService;
        this.jobSeekerWebAddressService = jobSeekerWebAddressService;
    }


    @Override
    public DataResult<GetAllCvInformationResponse> getAllCvInformationByJobSeekerId(int jobSeekerId) {
        JobSeeker jobSeeker = jobSeekerDao.findById(jobSeekerId).orElseThrow();

        GetAllCvInformationResponse getAllCvInformationResponse = new GetAllCvInformationResponse();
        getAllCvInformationResponse.setJobSeekerId(jobSeekerId);
        getAllCvInformationResponse.setJobExperiences(jobExperienceService.getAllByJobSeekerIdOrderByGraduatedYearDesc(jobSeekerId).getData());
        getAllCvInformationResponse.setJobSeekerImages(jobSeekerImageService.getAllJobSeekerImagesByJobSeekerId(jobSeekerId).getData());
        getAllCvInformationResponse.setLanguages(languageService.getAllLanguagesByJobSeekerId(jobSeekerId).getData());
        getAllCvInformationResponse.setSchools(schoolService.getAllByJobSeekerIdOrderByGraduatedYearDesc(jobSeekerId).getData());
        getAllCvInformationResponse.setTechnologies(technologyService.getAllTechnologiesByJobSeekerId(jobSeekerId).getData());
        getAllCvInformationResponse.setCoverLetter(coverLetterService.getCoverLetterByJobSeekerId(jobSeekerId).getData());
        getAllCvInformationResponse.setJobSeekerWebAddress(jobSeekerWebAddressService.getJobSeekerWebAddressResponse(jobSeekerId).getData());

        return new SuccessDataResult<>(getAllCvInformationResponse);
    }
}
