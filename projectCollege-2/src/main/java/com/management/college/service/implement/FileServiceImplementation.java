package com.management.college.service.implement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.college.entity.File;
import com.management.college.repository.FileRepository;
import com.management.college.services.FileService;

 
@Service
public class FileServiceImplementation implements FileService {
 
	// @Autowired annotation used to inject
    // the object dependency of FileRepository
    @Autowired 
    FileRepository fileRepository;
   
    @Override
    public List<File> getAllFiles() {
        // fetch all the files form database
        return fileRepository.findAll();
    }
    public void saveAllFilesList(List<File> fileList) {
        // Save all the files into database
        for (File file : fileList)
            fileRepository.save(file);
    }
}