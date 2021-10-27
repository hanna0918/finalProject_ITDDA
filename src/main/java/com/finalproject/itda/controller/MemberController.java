package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MemberService;
import com.finalproject.itda.vo.MemberBaseVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
    @Autowired
    private BCryptPasswordEncoder pwEncoder;
	// 로그인
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(MemberBaseVO vo, HttpSession session) {
        String rawPw = "";
        String encodePw = "";
    
        MemberBaseVO lvo = memberService.login(vo);    // 제출한아이디와 일치하는 아이디 있는지 
        
        if(lvo != null) {            // 일치하는 아이디 존재시
            
            rawPw = vo.getM_userpwd();        // 사용자가 제출한 비밀번호
            encodePw = lvo.getM_userpwd();        // 데이터베이스에 저장한 인코딩된 비밀번호
            
            if(true == pwEncoder.matches(rawPw, encodePw)) {        // 비밀번호 일치여부 판단
                lvo.setM_userpwd("");                    // 인코딩된 비밀번호 정보 지움
    			session.setAttribute("login", lvo.getM_userid());
    			session.setAttribute("logname", lvo.getM_username());
    			session.setAttribute("logseq", (int)lvo.getM_seq());
    			session.setAttribute("lognick", lvo.getM_nickname());
    			
    			
				session.setAttribute("m_rank", (int)lvo.getM_rank());
				session.setAttribute("m_name", lvo.getM_name());
    			System.out.println("랭크는 = " + session.getAttribute("m_rank"));
    			System.out.println("확인용>>>>>>>>>>>>"+lvo.getM_seq());
                return "redirect:/";        // 메인페이지 이동
            } 
        }
        
        
        
        return "redirect:/";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession s) {
		s.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String m_userid) throws Exception {
//		logger.info("memberIdChk() 진입");
		int result = memberService.idCheck(m_userid);
//		logger.debug("결과값 = " + result);
		if(result != 0) {
			return "fail";	// 중복 아이디가 존재
		} else {
			return "success";	// 중복 아이디 x
		}	
	} // memberIdChkPOST() 종료

	// 닉네임 중복 검사
	@RequestMapping(value = "/memberNickChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberNickChkPOST(String m_nickname) throws Exception {
		int result = memberService.nickCheck(m_nickname);
		logger.info("결과값"+result);
		if(result != 0) {
			return "fail";	// 중복 닉 존재
		} else {
			return "success";	// 중복 닉 없음
		}	
	} // memberNickChkPOST() 종료
	
	
	// 회원가입
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(MemberBaseVO vo, Model model, HttpServletRequest req) {
		System.out.println("근데 왜 안되니");
		
        String rawPw = "";            // 인코딩 전 비밀번호
        String encodePw = "";        // 인코딩 후 비밀번호
        
        rawPw = vo.getM_userpwd();            // 비밀번호 데이터 얻음
        encodePw = pwEncoder.encode(rawPw);        // 비밀번호 인코딩
        vo.setM_userpwd(encodePw);            // 인코딩된 비밀번호 member객체에 다시 저장
        
        /* 회원가입 쿼리 실행 */
        int result = memberService.join(vo);
		model.addAttribute("result", result);
		
//		int result = memberService.join(vo);
//		model.addAttribute("result", result);
		
		String contextPath = req.getSession().getServletContext().getRealPath("/img");
//    	System.out.println(contextPath);
    	String[] pathSplit = contextPath.split("\\\\");
    	for(int i=0; i < pathSplit.length; i ++) {
    		System.out.println("split "+ i +" 번째 = "+pathSplit[i]);
    	}
    	System.out.println("근데 왜 안되니2");
    	String path =  pathSplit[0] + "/" + pathSplit[1] + "/itda/src/main/webapp/upload";
    	System.out.println(path);
		// 파일업로드를 위해서는 HttpServletRequest객체를 이용하여 MultipartHttpServletRequest객체를 구하여야 한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		// mr에서 MultipartFile객체를 얻어와야 한다.
		List<MultipartFile> files = mr.getFiles("input-files");
		// 업로드한 파일이 있으면
		System.out.println("근데 왜 안되니3");
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
		
		
		return "register/joinResult";

	}
	
	
	

}
