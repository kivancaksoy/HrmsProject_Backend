package kodlamaio.hrmsProject.business.services.storage;


import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.enums.StorageType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadFile(MultipartFile file) throws IOException;
    StorageType getFileStorageName();
}
