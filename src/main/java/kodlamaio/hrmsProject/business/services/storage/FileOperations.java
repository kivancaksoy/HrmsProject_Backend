package kodlamaio.hrmsProject.business.services.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileOperations {

    //get filename with extension
    public static String getFileNameWithExtension(MultipartFile file) {

        String fileNameWithExtension = file.getOriginalFilename();
        return fileNameWithExtension;


    }

    //get filename without extension
    public static String getFileName(MultipartFile file) {
        int fileIndex = getFileNameWithExtension(file).lastIndexOf('.');
        String fileName = getFileNameWithExtension(file).substring(0, fileIndex);
        return fileName;

    }

    //get file as bytes
    public static byte[] getFileBytes(MultipartFile file) {
        byte[] fileBytes;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileBytes;

    }
}
