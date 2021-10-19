package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MemberService;
import com.finalproject.itda.vo.MemberVO;

@Controller
public class MemberController {
	@Inject
	MemberService memberService;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MemberController.class);
	
    @Autowired
    private BCryptPasswordEncoder pwEncoder;
	// 로그인
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(MemberVO vo, HttpSession session) {
        String rawPw = "";
        String encodePw = "";
    
        MemberVO lvo = memberService.login(vo);    // 제출한아이디와 일치하는 아이디 있는지 
        
        if(lvo != null) {            // 일치하는 아이디 존재시
            
            rawPw = vo.getM_userpwd();        // 사용자가 제출한 비밀번호
            encodePw = lvo.getM_userpwd();        // 데이터베이스에 저장한 인코딩된 비밀번호
            
            if(true == pwEncoder.matches(rawPw, encodePw)) {        // 비밀번호 일치여부 판단
                lvo.setM_userpwd("");                    // 인코딩된 비밀번호 정보 지움
    			session.setAttribute("login", lvo.getM_userid());
    			session.setAttribute("logname", lvo.getM_username());
    			session.setAttribute("logseq", lvo.getM_seq());
    			session.setAttribute("lognick", lvo.getM_nickname());

                return "redirect:/";        // 메인페이지 이동
            } 
        }
        return "redirect:/";
//		MemberVO resultVO = memberService.login(vo);
//		ModelAndView mav = new ModelAndView();
//
//		if (resultVO == null) {// 로그인 실패
//			mav.setViewName("redirect:login");
//		} else {// 로그인 성공
//			session.setAttribute("login", resultVO.getM_userid());
//			session.setAttribute("logname", resultVO.getM_username());
//			session.setAttribute("logseq", resultVO.getM_seq());
//			session.setAttribute("lognick", resultVO.getM_nickname());
//			mav.setViewName("redirect:/");
//		}
//		return mav;
		
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
	public String joinOk(MemberVO vo, Model model) {

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
		
		return "register/joinResult";

	}

}
