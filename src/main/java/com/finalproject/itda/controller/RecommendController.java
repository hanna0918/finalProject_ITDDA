package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

@Controller
public class RecommendController {
	@Inject
	RecommendService recommendService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
	//uploadPath 추가
	@Resource(name="uploadPath")
	private String uploadPath;
	
	// 추천게시판 리스트
	@RequestMapping(value="/recommendList", method = RequestMethod.GET)
	public ModelAndView recommendList(RecommendVO vo) {
		ModelAndView mav = new ModelAndView();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.addObject("pVo", recommendService.page(pVo));
		mav.addObject("list", recommendService.recommendList(pVo));
		mav.setViewName("/recommend/recommendList");
		return mav;
	}
	
	@RequestMapping(value="/recommendListTagSearch", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tagSearch(RecommendPagingVO pVo){
		Map<String, Object> map = new HashMap<String, Object>();
		RecommendPagingVO ppVo = recommendService.page(pVo);
		ppVo.setNowPage(pVo.getNowPage());
		map.put("pVo", ppVo);
		map.put("vo", recommendService.recommendList(pVo));
		return map;
	}

	//異붿쿇寃뚯떆�뙋 湲��옉�꽦 view
	@RequestMapping(value="/recommendWrite")
	public String recommendWrite() {
		return "/recommend/recommendWrite";
	}
	
	//異붿쿇寃뚯떆�뙋 湲��옉�꽦 insert
	@RequestMapping(value="/recommendWriteOk", method = RequestMethod.POST)
	public ModelAndView recommendWriteOk(RecommendVO vo, HttpServletRequest req) throws Exception {
//		vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
//		
//		System.out.println(vo.getM_seq());
//		
		ModelAndView mav = new ModelAndView();
//	
//
////		//이미지 추가 부분-------------------------start
////		
////		//////////////////////////////
////		
////		 String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
////		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
////		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
////
////		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
////			// 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
////
////			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
////					ymdPath);
////
////			// gdsImg에 원본 파일 경로 + 파일명 저장
////			vo.setI_url(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
////			// gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
////			vo.setThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
////					+ fileName);
////
////		} else { // 첨부된 파일이 없으면
////			fileName = File.separator + "images" + File.separator + "none.png";
////			// 미리 준비된 none.png파일을 대신 출력함
////
////			vo.setI_url(fileName);
////			vo.setThumbImg(fileName);
////		}
////		
////		//이미지 추가 부분-------------------------end
//		//이미지 추가 2번쨰 ---------------end
//		String fileName = files.getOriginalFilename();
//		System.out.println(fileName+"........나와아");
//        File target = new File(uploadPath, fileName);
//        
//        //경로 생성
//        if ( ! new File(uploadPath).exists()) {
//            new File(uploadPath).mkdirs();
//        }
//        //파일 복사
//        try {
//            FileCopyUtils.copy(files.getBytes(), target);
//            mav.addObject("file", files);
//        } catch(Exception e) {
//            e.printStackTrace();
//            mav.addObject("file", "error");
//        }
        
    	int cnt = recommendService.recommendWriteOk(vo);
		
//    	String path = req.getSession().getServletContext().getRealPath("/img");
    	String contextPath = req.getSession().getServletContext().getRealPath("/img");
//    	System.out.println(contextPath);
    	String[] pathSplit = contextPath.split("\\\\");
    	for(int i=0; i < pathSplit.length; i ++) {
    		System.out.println("split "+ i +" 번째 = "+pathSplit[i]);
    	}
    	
    	String path =  pathSplit[0] + "/" + pathSplit[1] + "/itda/src/main/webapp/upload";
    	System.out.println(path);
		// 파일업로드를 위해서는 HttpServletRequest객체를 이용하여 MultipartHttpServletRequest객체를 구하여야 한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		// mr에서 MultipartFile객체를 얻어와야 한다.
		List<MultipartFile> files = mr.getFiles("input-file");
		// 업로드한 파일이 있으면
		List<String> fileList = new ArrayList<String>(); // 업로드된 파일명들을 저장할 곳
		System.out.println("recommendWriteOk 들어옴");
		if(files != null) {
			System.out.println("recommendWriteOk if 문 들어옴");
			// 업로드 구현
			System.out.println("files.size = " + files.size());
			for(int i=0; i<files.size(); i++) {
				// 업로드 할 MultipartFile 객체를 얻어온다.
				MultipartFile mf = files.get(i);
				// 원래 파일명
				String fname = mf.getOriginalFilename(); // ccc.jpg
				System.out.println("fname=" + fname);
				if(fname!=null && !fname.equals("")) {
					System.out.println("두번째 if문 들어옴");
					// 같은 파일명이 서버에 있는지 확인
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) { // 파일존재여부 확인 --> boolean
						System.out.println("세번째 if문 들어옴");
						for(int num=1; ;num++) {
							// 파일명 변경
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0, point);
							String orgFileExt = fname.substring(point+1);
							String newFileName = orgFileName + "(" + num + ")." + orgFileExt; // ex) ccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) {
								break;
							}
						} // for
					} // if
					// 업로드 실행
					System.out.println("업로드 실행?!");
					try {
						mf.transferTo(newFileObj);
					} catch (Exception e) {
						e.printStackTrace();
					}
					fileList.add(newFileObj.getName());
				} // for
			} // if
		}
		
		if(cnt>0) {
			mav.setViewName("redirect:recommendList");
		}else {
			mav.setViewName("redirect:recommendWrite");
		}
		
		System.out.println(vo.getI_url());
		mav.setViewName("redirect:recommendList");
		
		return mav;
	}
	
	// 湲�蹂닿린
	@RequestMapping(value="recommendView")
	public ModelAndView recommentView(int board_seq) {
		ModelAndView mav = new ModelAndView();
		int cnt = recommendService.countHit(board_seq);
		mav.addObject("vo", recommendService.recommendView(board_seq));
		mav.setViewName("recommend/recommendView");
		return mav;
	}
	
	
	
}
