package com.finalproject.itda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.AdminService;
import com.finalproject.itda.vo.BoardVO;

import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.QuestionVO;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
    private BCryptPasswordEncoder pwEncoder;
	//Q & A wait 이동 및 데이터 넘기기
	@RequestMapping(value="/adminQnawait")
	public String AdminQnaWait(Model model) {
		model.addAttribute("list", adminService.QuestionList());
		return "admin/adminQnawait";
	}
	
	//Q & A wait 모달에 출력
	@RequestMapping(value="/QnaModalwaitView", method=RequestMethod.POST)
	@ResponseBody public QuestionVO AdminQnaWaitModalView(QuestionVO vo) {
		System.out.println(vo.getQ_number()); 
		QuestionVO Qnavo =adminService.QusetionWaitModallist(vo);
	return Qnavo; }
	
	//Q & A wait 모달에서 update
		@RequestMapping(value="/CallwaitUpdate", method=RequestMethod.POST)
		   public ModelAndView AdminQnaUpdate(QuestionVO vo) {
		
				System.out.println(vo.getQ_number());
				System.out.println(vo.getQ_result_state());
				System.out.println(vo.getQ_result());
				
		      int cnt = adminService.QusetionupdateModal(vo);
		      ModelAndView mav = new ModelAndView();
		  	if (cnt > 0) { 
				mav.setViewName("redirect:adminQnawait");
			} 
		      return mav;
		   }
	//-------------------------
		//Q & A result 이동 및 데이터 넘기기
		@RequestMapping(value="/adminQnaresult")
		public String AdminQnaresult(Model model) {
			model.addAttribute("list", adminService.QuestionResultList());
			return "admin/adminQnaresult";
		}
		
	@RequestMapping(value="AdminMemberlist")
	public String AdminMemberList(Model model) {
		model.addAttribute("list", adminService.AMemberList());
		return "admin/adminMemberList";
	}
	
	//어드민 추가하기
	@RequestMapping(value = "/MemberInsert")
	public String MemberInsert() {
		return "admin/adminInsert";}

	//어드민 추가
	@RequestMapping(value = "/adminInsertOk", method = RequestMethod.POST)
	public ModelAndView adminInsertOk(MemberBaseVO vo, Model model) {
		

        String rawPw = "";            // 인코딩 전 비밀번호
        String encodePw = "";        // 인코딩 후 비밀번호
        
        
        rawPw = vo.getM_userpwd();
        encodePw = pwEncoder.encode(rawPw);
        vo.setM_userpwd(encodePw);
		
		int cnt = adminService.MemberInsert(vo);
		ModelAndView mav = new ModelAndView();
		if (cnt > 0) { 
			mav.setViewName("redirect:AdminMemberlist");
		} else {
			mav.setViewName("redirect:MemberInsert");
		}
		return mav;
	}
//-------------------------

//-------------------------
//멤버리스트 출력
	@RequestMapping(value = "/MemberList")
	public String AdminMember(Model model) {
		model.addAttribute("list", adminService.MemberList());
		return "admin/MemberList";}
	
	
//멤버 모달에 출력
	@RequestMapping(value="/MemberView", method=RequestMethod.POST)
	@ResponseBody public MemberBaseVO AdminMemberView(MemberBaseVO vo) {
			System.out.println(vo.getM_seq()); 
			MemberBaseVO membervo =adminService.MemberView(vo);
			return membervo; }
	
//멤버 모달에서 update
	@RequestMapping(value="/MemberUpdate", method=RequestMethod.POST)
	   public ModelAndView MemberUpdate(MemberBaseVO vo) {
		
		
	      int cnt = adminService.MemberUpdate(vo);
	      ModelAndView mav = new ModelAndView();
	      if(cnt>0) { 
	         mav.setViewName("redirect:MemberList");
	      } else {
	         mav.setViewName("redirect:admin");
	      }
	      return mav;
	   }
//-------------------------
	//신고 게시판 이동
			@RequestMapping(value="/BoardCallList")
			public String AdminBlackBoard(Model model) {
				model.addAttribute("list",adminService.BoardcallList());
				return "admin/adminboardCall";}
			
	//신고 게시판 모달에 출력	
			@RequestMapping(value="/CallBoardBlackView", method=RequestMethod.POST)
			@ResponseBody public BoardVO AdminMemberView(BoardVO vo) {
					System.out.println(vo.getM_seq()); 
					BoardVO boardvo =adminService.CallBoardView(vo);
					return boardvo; }
			
			
	//신고 게시판 목록 확인하기
			@RequestMapping(value="/CallBoardUpdate", method=RequestMethod.POST)
			   public ModelAndView CallBoardVo(BoardVO vo) {
				System.out.println("갓순찬은 해냈다.");  
				System.out.println(vo.getBoard_blockcontent());
				System.out.println(vo.getBoard_seq());
				int cnt = adminService.CallBoardUpdate(vo);
			      ModelAndView mav = new ModelAndView();
			      if(cnt>0) { 
			         mav.setViewName("redirect:BoardCallList");
			     	System.out.println("완료됨.");
			      }
			      return mav;
			   }
//-------------------------

//-----------
			//블럭게시물 이동  뿌려주기
		@RequestMapping(value="/BoardBlackList")
		public String AdminBlackBoardList(Model model) {
			model.addAttribute("list",adminService.BlackBoardList());
			return "admin/adminboardblackList";}		
			
			//블럭게시물 모달에 출력
		@ResponseBody
		@RequestMapping(value="/BlackBoardBlackView", method=RequestMethod.POST)
		public BoardVO AdminBlackView(BoardVO vo) {
			System.out.println(vo.getM_seq()); 
			BoardVO boardvo = adminService.BlackBoardstateView(vo);
			return boardvo; 
			}
		
		//블럭 게시판 목록 확인하기
		@RequestMapping(value="/BlockBoardUpdate", method=RequestMethod.POST)
		  public ModelAndView BlockBoardVo(BoardVO vo) {
			int cnt = adminService.BlockBoardUpdate(vo);
		      ModelAndView mav = new ModelAndView();
		      if(cnt>0) { 
		         mav.setViewName("redirect:BoardBlackList");
		     	System.out.println("블럭완료됨.");
		      }
		      return mav;
		   }
		
//-----
	
	   // 모든 게시시글 보기 및 이동 이동
		@RequestMapping(value="/BoardAllView")
		public String AdminAllBoard(Model model) {
			model.addAttribute("list",adminService.AllboardList());
			return "admin/adminboardList";}
//---------------------
		

		
		
		
		

				

}
