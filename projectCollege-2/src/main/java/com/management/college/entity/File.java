package com.management.college.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
 

@Entity  
 

@Table(name = "file")
public class File {
   
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
    
    @Column(name = "id")
    long id;
    @Column(name = "name")
    String fileName;
    @Lob
    @Column(name = "content")
    String content;
    @Column(name = "filetype")
    private String fileType;
 
    public File() {
        super();
    }
    public File(String fileName, String content, String fileType) {
        super();
        this.fileName = fileName;
        this.content = content;
        this.fileType = fileType;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}