package com.nac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "file_metadata")
public class FileMetadata {
    @Id
    @Column(name = "file_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fileId;
    @Column(name = "file_upload_message")
    private String message;
    @Column(name = "file_version")
    private String version;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "bucket")
    private String bucket;

}
