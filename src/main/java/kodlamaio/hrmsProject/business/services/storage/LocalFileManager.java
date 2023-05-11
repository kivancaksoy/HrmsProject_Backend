package kodlamaio.hrmsProject.business.services.storage;

import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.enums.StorageType;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//Sonradan düzenlenecek.
public class LocalFileManager implements FileService {
    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        //file upload
        File convFile = new File("src/main/resources/temporaryFolder/" + file.getOriginalFilename());
        String path = convFile.getAbsolutePath();
        file.transferTo(Path.of(convFile.getAbsolutePath()));

        //file delete
        //convFile.delete();
        return path;
    }

    public StorageType getFileStorageName(){
        return StorageType.Local;
    }

}
