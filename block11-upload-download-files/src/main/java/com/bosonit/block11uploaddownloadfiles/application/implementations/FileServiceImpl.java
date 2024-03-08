/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles.application.implementations;

import com.bosonit.block11uploaddownloadfiles.application.services.IFileService;
import com.bosonit.block11uploaddownloadfiles.domain.File;
import com.bosonit.block11uploaddownloadfiles.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * FileServiceImpl class. Implements IFileService interface and contains all methods related to File's CRUD.
 */
@Service
public class FileServiceImpl implements IFileService<File> {
    // Attributes
    @Autowired
    FileRepository fileRepository;
    private String uploadPath = "C:/tmp";

    // Methods
    @Override
    public File saveFile(MultipartFile multipartFile, String category) throws IOException {
        File newFile = new File();
        newFile.setName(multipartFile.getOriginalFilename());
        newFile.setUploadDate(new Date());
        newFile.setCategory(category);

        byte [] fileBytes = multipartFile.getBytes();
        Path filePath = Paths.get(uploadPath, multipartFile.getOriginalFilename());
        Files.write(filePath, fileBytes);

        return fileRepository.save(newFile);
    }

    @Override
    public void setPath(String path) {
        this.uploadPath = path;
    }

    @Override
    public File getFileById(long id) {
        return fileRepository.findById(id).orElseThrow();
    }

    @Override
    public File getFileByName(String name) {
        return fileRepository.findByName(name);
    }

    @Override
    public byte[] getFileContent(File file) {
        try {
            Path filePath = Paths.get(uploadPath, file.getName());
            return Files.readAllBytes(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
