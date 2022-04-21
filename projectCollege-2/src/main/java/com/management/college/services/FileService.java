package com.management.college.services;

import java.util.List;

import com.management.college.entity.File;

public interface FileService {
   List<File> getAllFiles();
   void saveAllFilesList(List<File> fileList);
}