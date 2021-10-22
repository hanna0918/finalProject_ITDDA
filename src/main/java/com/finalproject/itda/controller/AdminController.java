package com.finalproject.itda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.finalproject.itda.service.AdminService;
import com.finalproject.itda.vo.MemberBaseVO;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
//어드민 이동
	@RequestMapping(value="/admin")
	public String test() {
		return "admin/admin";
	}
	//-------------------------
	
//어드민 추가
	@RequestMapping(value = "/MemberInsert")
	public String MemberInsert() {
		return "admin/adminInsert";}

	@RequestMapping(value = "/adminInsertOk", method = RequestMethod.POST)
	public ModelAndView adminInsertOk(MemberBaseVO vo, HttpSession session) {
		int cnt = adminService.MemberInsert(vo);
		ModelAndView mav = new ModelAndView();
		if (cnt > 0) { 
			mav.setViewName("redirect:MemberInsert");
		} else {
			mav.setViewName("redirect:admin");
		}
		return mav;
	}
//------------

//멤버리스트 출력
	@RequestMapping(value = "/MemberList")
	public String AdminMember(Model model) {
		model.addAttribute("list", adminService.MemberList());
		return "admin/MemberList";}
//멤버 모달에 출력
	@RequestMapping(value="/MemberView", method=RequestMethod.POST)
	@ResponseBody public MemberBaseVO AdminMemberView(MemberBaseVO vo) {
			System.out.println(vo.getM_seq()); 
			MemberBaseVO MemberBaseVO =adminService.MemberView(vo);
			return MemberBaseVO; }
	
//멤버 모달에서 update
	@RequestMapping(value="/MemberUpdate", method=RequestMethod.POST)
	   public ModelAndView MemberUpdate(MemberBaseVO vo) {
	      int cnt = adminService.MemberUpdate(vo);
	      ModelAndView mav = new ModelAndView();
	      if(cnt>0) { // 글쓰기 성공
	         mav.setViewName("redirect:MemberList");
	      } else {
	         mav.setViewName("redirect:admin");
	      }
	      return mav;
	   }
	
//----------
	  

	  
//게시판 이동
		@RequestMapping(value = "/BoardAllView")
		public String AdminAllBoard(Model model) {
			return "admin/adminboardList";}
//---------------------
		

		
		
//신고 게시판 이동
		@RequestMapping(value="/BoardBlackList")
		public String AdminBlackBoard(Model model) {
			return "admin/adminboardCall";}
//----------------------------
				

}
