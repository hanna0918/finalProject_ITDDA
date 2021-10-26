package com.finalproject.itda.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonController {
	
	@RequestMapping("/file/upload")
	public String uploadFile(MultipartFile[] upload, HttpServletRequest request) {
		
		//파일 업로들 될 경로
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload/file");
		
		File dir = new File(saveDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		for(MultipartFile f : upload) {
			//기존 파일 이름을 받고 확장자 저장
			String orifileName = f.getOriginalFilename();
			String ext = orifileName.substring(orifileName.lastIndexOf("."));
			
		}
		
		return null;
		
		
	}
}
