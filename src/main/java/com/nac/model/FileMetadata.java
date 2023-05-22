package com.nac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String fileId;
    private String message;
    private String version;
    private String filePath;
    private String bucket;

    public FileMetadata(){

    }

    public FileMetadata(String fileId, String message, String version, String filePath, String bucket) {
        this.fileId = fileId;
        this.message = message;
        this.version = version;
        this.filePath = filePath;
        this.bucket = bucket;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
