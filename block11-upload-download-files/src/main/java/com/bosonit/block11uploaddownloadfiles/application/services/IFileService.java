/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles.application.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * IFileService interface. Defines most File's business logic.
 */
public interface IFileService<File> {
    // Post method
    File saveFile(MultipartFile file, String category) throws IOException;

    // Get methods
    void setPath(String path);
    File getFileById(long id) throws IOException;
    File getFileByName(String name) throws IOException;
    byte[] getFileContent(File file);

}
