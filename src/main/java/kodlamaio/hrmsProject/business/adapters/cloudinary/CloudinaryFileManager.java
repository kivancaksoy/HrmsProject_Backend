package kodlamaio.hrmsProject.business.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrmsProject.business.services.storage.FileOperations;
import kodlamaio.hrmsProject.business.services.storage.FileService;
import kodlamaio.hrmsProject.entities.concretes.jobSeekerCvInformations.enums.StorageType;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryFileManager implements FileService {
    private final Environment environment;

    public CloudinaryFileManager(Environment environment) {
        this.environment = environment;
    }

    public String uploadFile(MultipartFile file) {

        Map<String, String> config = new HashMap<String, String>();
        config.put("cloud_name", environment.getProperty("cloudinary.cloud_name"));
        config.put("api_key", environment.getProperty("cloudinary.api_key"));
        config.put("api_secret", environment.getProperty("cloudinary.api_secret"));
        Cloudinary cloudinary = new Cloudinary(config);


        //file operations
        String fileNameWithExtension = FileOperations.getFileNameWithExtension(file);
        String fileName = FileOperations.getFileName(file);
        byte[] fileBytes = FileOperations.getFileBytes(file);
        String filePath = environment.getProperty("cloudinary.file_folder_name") + fileName;

        Object imageVersion = "";

        try {
            imageVersion = cloudinary.uploader().upload(fileBytes, ObjectUtils.asMap( "public_id", filePath)).get("version");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        String fileFullPath = "v" + imageVersion + "/" + environment.getProperty("cloudinary.file_folder_name") + fileNameWithExtension;


// Transform
        //String url = cloudinary.url().transformation(new Transformation<>().width(100).height(150).crop("fill")).generate(environment.getProperty("cloudinary.file_folder_name") + fileNameWithExtension);
        //System.out.println(url);
        return  fileFullPath;
    }

    @Override
    public StorageType getFileStorageName() {
        return StorageType.Cloudinary;
    }


}
