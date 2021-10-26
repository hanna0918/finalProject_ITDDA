package com.finalproject.itda.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView recommendWriteOk(RecommendVO vo, HttpSession ses, MultipartFile file ) throws Exception {
		vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
		
		System.out.println(vo.getM_seq());
		
		ModelAndView mav = new ModelAndView();
	

//		//이미지 추가 부분-------------------------start
//		
//		//////////////////////////////
//		
//		 String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
//		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
//		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
//
//		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
//			// 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
//
//			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(),
//					ymdPath);
//
//			// gdsImg에 원본 파일 경로 + 파일명 저장
//			vo.setI_url(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
//			// gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
//			vo.setThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_"
//					+ fileName);
//
//		} else { // 첨부된 파일이 없으면
//			fileName = File.separator + "images" + File.separator + "none.png";
//			// 미리 준비된 none.png파일을 대신 출력함
//
//			vo.setI_url(fileName);
//			vo.setThumbImg(fileName);
//		}
//		
//		//이미지 추가 부분-------------------------end
		//이미지 추가 2번쨰 ---------------end
		String fileName = file.getOriginalFilename();
		System.out.println(fileName+"........나와아");
        File target = new File(uploadPath, fileName);
        
        //경로 생성
        if ( ! new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
            mav.addObject("file", file);
        } catch(Exception e) {
            e.printStackTrace();
            mav.addObject("file", "error");
        }
        
    	int cnt = recommendService.recommendWriteOk(vo);
		
		if(cnt>0) {
			mav.setViewName("redirect:recommendList");
		}else {
			mav.setViewName("redirect:recommendWrite");
		}
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
