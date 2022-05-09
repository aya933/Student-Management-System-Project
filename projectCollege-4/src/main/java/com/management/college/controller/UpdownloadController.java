package com.management.college.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.management.college.entity.Updownload;
import com.management.college.service.implement.UpdownloadService;
import com.sun.xml.txw2.Document;

@Controller

public class UpdownloadController {
	
	 @Autowired
	 private UpdownloadService service;
	 @GetMapping("/Updownload")
	 public String home(Model model) {
	  List<Updownload> list =  service.getAllUpdownload();
	  model.addAttribute("list", list);
	  return "Updownload";
	 }
	 @PostMapping("/Updownload/upload")
	 public String fileUpload(@RequestParam("file") MultipartFile file,  Model model) throws IOException {
		 Updownload updownload = new Updownload();
		  String fileName = file.getOriginalFilename();
		  updownload.setProfilePicture(fileName);
		  updownload.setContent(file.getBytes());
		  updownload.setSize(file.getSize());
		  service.createUpdownload(updownload);
		  model.addAttribute("success", "File Uploaded Successfully!!!");
		  return "Updownload";
	  
	 }
	 
	 
	 @GetMapping("/Updownload/downloadfile")
	 public void downloadFile(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
	  Optional<Updownload> temp = service.findUpdownloadById(id);
	  if(temp!=null) {
	   Updownload updownload = temp.get();
	   response.setContentType("application/octet-stream");
	   String headerKey = "Content-Disposition";
	   String headerValue = "attachment; filename = "+updownload.getProfilePicture();
	   response.setHeader(headerKey, headerValue);
	   ServletOutputStream outputStream = response.getOutputStream();
	   outputStream.write(updownload.getContent());
	   outputStream.close();
	  }
	 }
	 
	 @GetMapping("/Updownload/image")
	 public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Updownload> updownload)
	   throws ServletException, IOException {
	  
	  updownload = service.findUpdownloadById(id);
	  response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
	  response.getOutputStream().write(updownload.get().getContent());
	  response.getOutputStream().close();
	 }
	}


