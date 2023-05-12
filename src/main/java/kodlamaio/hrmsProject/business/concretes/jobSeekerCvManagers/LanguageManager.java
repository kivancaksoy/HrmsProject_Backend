package kodlamaio.hrmsProject.business.concretes.jobSeekerCvManagers;

import kodlamaio.hrmsProject.business.abstracts.jobSeekerCvServices.LanguageService;
import kodlamaio.hrmsProject.business.requests.jobSeekerCvInformationRequests.CreateLanguageRequest;
import kodlamaio.hrmsProject.business.responses.jobSeekerCvInformationResponses.GetAllLanguagesResponse;
import kodlamaio.hrmsProject.core.utilities.mappers.ModelMapperService;
import kodlamaio.hrmsProject.core.utilities.results.DataResult;
import kodlamaio.hrmsProject.core.utilities.results.Result;
import kodlamaio.hrmsProject.core.utilities.results.SuccessDataResult;
import kodlamaio.hrmsProject.core.utilities.results.SuccessResult;
import kodlamaio.hrmsProject.dataAccess.abstracts.jobSeekerCvInformationDaos.LanguageDao;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;
    private final ModelMapperService modelMapperService;

    @Autowired
    public LanguageManager(LanguageDao languageDao, ModelMapperService modelMapperService) {
        this.languageDao = languageDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(List<CreateLanguageRequest> createLanguageRequests) {
        List<Language> languages =
                createLanguageRequests.stream().map(createLanguageRequest ->
                        modelMapperService.forRequest().map(createLanguageRequest, Language.class)).toList();
        languageDao.saveAll(languages);
        return new SuccessResult("Languages added.");
    }

    @Override
    public DataResult<List<GetAllLanguagesResponse>> getAllLanguagesByJobSeekerId(int jobSeekerId) {
        List<Language> languages = languageDao.findAllByJobSeekerId(jobSeekerId);

        List<GetAllLanguagesResponse> getAllLanguagesResponses =
                languages.stream().map(language ->
                        modelMapperService.forResponse().map(language, GetAllLanguagesResponse.class)).toList();
        return new SuccessDataResult<>(getAllLanguagesResponses);
    }
}
