/**
 * @author Albert Lozano Blasco
 * @version 1.0
 */

package com.bosonit.block11uploaddownloadfiles.controller;

import com.bosonit.block11uploaddownloadfiles.application.services.IFileService;
import com.bosonit.block11uploaddownloadfiles.domain.File;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * FileController class. RESTController to manage all HTTP methods for a file.
 */
@RestController
@RequestMapping("/file")
public class FileController {
    // Attributes
    @Autowired
    private IFileService<File> fileService;

    // Methods
    // Post methods
    @Operation(
            summary = "Upload a file",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully uploaded file.",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Entity not found"),
                    @ApiResponse(responseCode = "500", description = "Error uploading file"),
                    @ApiResponse(responseCode = "400", description = "File empty or incorrect extension")
            }
    )
    @PostMapping(value = "/upload/{type}", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<File> uploadFile(
            @RequestParam(name = "file") MultipartFile file,
            @PathVariable("type") String type,
            @RequestParam("category") String category
    ) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (fileExtension != null && !fileExtension.equalsIgnoreCase(type)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            File savedFile = fileService.saveFile(file, category);
            return new ResponseEntity<>(savedFile, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get methods
    @GetMapping("/setpath")
    public ResponseEntity<String> setPath(@RequestParam("path") String path) {
        fileService.setPath(path);
        return ResponseEntity.ok("Path set successfully");
    }

    @Operation(
            summary = "Download a file by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully downloaded file.", content = @Content(
                            mediaType = "application/octet-stream",
                            schema = @Schema(type = "string", format = "binary"))),
                    @ApiResponse(responseCode = "404", description = "Entity or file not found"),
                    @ApiResponse(responseCode = "500", description = "Error downloading file")
            }
    )
    @GetMapping(value = "/downloadbyid")
    public ResponseEntity<byte[]> downloadFileById(@RequestParam(name = "id") Long id) {
        try {
            File file = fileService.getFileById(id);
            byte[] fileContent = fileService.getFileContent(file);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(fileContent);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Download a file by name",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully downloaded file.", content = @Content(
                            mediaType = "application/octet-stream",
                            schema = @Schema(type = "string", format = "binary"))),
                    @ApiResponse(responseCode = "404", description = "Entity or file not found"),
                    @ApiResponse(responseCode = "500", description = "Error downloading file")
            }
    )
    @GetMapping(value = "/downloadbyname")
    public ResponseEntity<byte[]> downloadFileByName(@RequestParam(name = "name") String name) {
        try {
            File file = fileService.getFileByName(name);
            byte[] fileContent = fileService.getFileContent(file);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", file.getName());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .headers(headers)
                    .body(fileContent);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
