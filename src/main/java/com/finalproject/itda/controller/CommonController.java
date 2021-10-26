package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.vo.DataVO;
import com.finalproject.itda.vo.RecommendVO;


@Controller
public class CommonController {
	
	//여러개 파일을 업로드할경우 (name이 같을경우)
		@RequestMapping(value="/dataUpload", method = RequestMethod.POST)
		public ModelAndView fileUploadTest(DataVO dVo, RecommendVO vo , HttpServletRequest req) {
			// vo -> userid, subject 

			//업로드 위치
			String path = req.getSession().getServletContext().getRealPath("/upload");
			System.out.println(path);
			//파일업로드를 위해서는 HttpServletRequest 객체를 이용하여 MultipartHttpServletRequest객체를 구하여야한다.
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
			
			//mr에서 MutipartFile객체를 얻어와야된다.
			List<MultipartFile> files= mr.getFiles("filename");
			//업로드된 파일명들을 저장할 곳
			List<String> fileList = new ArrayList<String>();
			//업로드한 파일이 있으면
			if(files!=null) {//DDDDD
				//업로드 구현
				for(int i=0; i<files.size(); i++) {// CCCCC
					//업로드 할 MultipartFile객체를 얻어오기
					MultipartFile mf = files.get(i);
					//원래 파일명
					String fname = mf.getOriginalFilename();
					System.out.println(fname);
					if (fname!=null && !fname.equals("")) {//~~~~~~~~~~~~~~~~~~~~~
						//같은파일명이 서버에 있는지 확인
						File fileObj = new File(path, fname);
						File newFileObj = new File(path, fname);
						if(fileObj.exists()) {	//파일존재여부 확인 있으면 true, 없으면 false	BBBB

							for(int num=1; ; num++) {//숫자가 없을떄 까지
								//파일명 변경
								int point = fname.lastIndexOf(".");
								String orgFileName = fname.substring(0,point);//파일명
								String orgFileExt = fname.substring(point+1);//확장자
								String newFileName = orgFileName+"("+num+")."+orgFileExt;//ccc(1).jpg
								newFileObj = new File(path, newFileName);
								if(!newFileObj.exists()) {
									break;
								}
							}
						
						}//if BBBBB
						try {
							//업로드 실행
							mf.transferTo(newFileObj);
							System.out.println("업로드완료");
						}catch(Exception e) {
							e.printStackTrace();
						}
							
						fileList.add(newFileObj.getName());
					}//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				}//for CCCCC
			}//if 	DDDDD
			vo.setFileList(fileList);
			ModelAndView mav = new ModelAndView();
			mav.addObject("vo", vo);
			mav.setViewName("result");
			return mav;
		}
}
