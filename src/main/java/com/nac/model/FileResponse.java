package com.nac.model;

public class FileResponse {
    private String fileId;
    private String message;
    private String filePath;

    public FileResponse(String fileId,String message,String filePath){
        this.fileId=fileId;
        this.message=message;
        this.filePath=filePath;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
