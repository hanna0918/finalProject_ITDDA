package com.finalproject.itda.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.QuestionService;
import com.finalproject.itda.vo.BoardVO;

@Controller
public class QuestionController {
	@Inject
	QuestionService questionService;
	//글보기
	@RequestMapping(value="/questionBoard")
	public String questionBoard(Model model) {
		model.addAttribute("list", questionService.questionBoardList());
		return "question/questionList";
	}
	
	//뷰어
	@RequestMapping(value="/questionView")
	public String questionView(Model model, int no) {
		model.addAttribute(model);
		return "question/questionView";
	}
	
	
	//글쓰기폼
	@RequestMapping(value="/writeQuestion")
	public String writeQuestion() {
		return "question/questionWriteForm";
	}
	
	//글등록
	@RequestMapping(value="/questionWriteOk", method=RequestMethod.POST)
	public ModelAndView questionWriteOk(BoardVO vo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		
		vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
		
		int cnt = questionService.questionInsert(vo);
		System.out.println(cnt);
		System.out.println(vo.getM_seq());
		System.out.println(vo.getB_content());
		System.out.println(vo.getBoard_subject());
		
		
		if(cnt>0) {//질문글 등록 성공!!!!!!!!!!!!!!
			mav.setViewName("redirect:questionBoard");
		}else {//실패........ㅜㅜㅜㅜㅜㅜㅜㅜ
			System.out.println("실패하엿습니다");
			mav.setViewName("redirect:questionBoard");
		}
		
		return mav;
	}
}
