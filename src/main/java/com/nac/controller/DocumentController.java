package com.nac.controller;

import com.nac.entity.FileMetadata;
import com.nac.model.FileResponse;
import com.nac.service.FileMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController("/document")
public class DocumentController {

    @Value("${upload.path}") // Specify the directory where files will be uploaded
    private String uploadPath;

    @Autowired
    private FileMetadataService fileMetadataService;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadFile(@RequestPart("file") MultipartFile file) {
        //check if file is empty
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new FileResponse("-1", "Uploaded file is empty", "null"));
        }

        try {
            // Generate a unique file ID
            String fileId = UUID.randomUUID().toString();

            // Normalize the file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String message="File uploaded successfully";

            // Save the file to the specified directory
            String filePath = uploadPath + File.separator + fileName;

            // Save file metadata using the service
            FileMetadata fileMetadata = fileMetadataService.saveFileMetadata(fileId,message , filePath);

            // Create a FileResponse object with the file ID and status message
            FileResponse fileResponse = new FileResponse(fileMetadata.getFileId(),fileMetadata.getMessage(), fileMetadata.getFilePath());

            file.transferTo(new File(filePath));
            return ResponseEntity.ok(fileResponse);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FileResponse("-1","File upload failed",""));
        }
    }

}
