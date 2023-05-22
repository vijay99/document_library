package com.nac.service;

import com.nac.model.FileMetadata;
import com.nac.model.FileResponse;
import com.nac.repo.FileMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileMetadataService {

    @Autowired
    private  FileMetadataRepository fileMetadataRepository;

    public FileMetadata saveFileMetadata(String fileId, String message, String filePath){
        //if it is first upload make it version one,as now hard coding
        String version = "Version 1.0";
        //As of now hardcode bucket as local
        String bucket ="Local";

        FileMetadata fileMetadata = new FileMetadata(fileId,message,version,filePath,bucket);
         return fileMetadataRepository.save(fileMetadata);

    }
}
