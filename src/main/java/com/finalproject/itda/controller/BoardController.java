package com.finalproject.itda.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.BoardService;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.Board_CommentVO;
import com.finalproject.itda.vo.PagingVO;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;

	/*
	 * @RequestMapping("/board/list") public ModelAndView boardList() { ModelAndView
	 * mav = new ModelAndView(); mav.addObject("list",
	 * boardService.boardAllSelect()); mav.setViewNam("board/list");
	 * 
	 * return mav;
	 * 
	 * }
	 */

	//자유게시판 리스트

	@RequestMapping("/freeBoard2") //,  value=    method = RequestMethod.GET
	public String freeBoard2(PagingVO pVo, Model model){
		model.addAttribute("list", boardService.boardList(pVo));
		return "/board/freeBoard2";
	}


	//글내용보기
	@RequestMapping("/freeview")
	public String boardView(Model model, int board_seq) {
		model.addAttribute("vo",boardService.freeView(board_seq));
		return "board/freeview";

	}

	//글쓰기 폼 
	@RequestMapping("/freeboardWrite") 
	public String freeboardWrite() {
		return "board/freeboardWrite";
	}

	//자유게시판 글쓰기 등록

	@RequestMapping(value="/freeWriteOk",method=RequestMethod.POST ) 
	public ModelAndView freeWriteOk(BoardVO vo, HttpSession ses) {
		System.out.println(Integer.parseInt((String)ses.getAttribute("logseq")));
		System.out.println("subject" + vo.getBoard_subject());
		System.out.println("content" +vo.getBoard_content());
		vo.setM_seq(Integer.parseInt((String)ses.getAttribute("logseq")));
		System.out.println("sessiong"+ vo.getM_seq());
		int result = boardService.freeboardWrite(vo);
		ModelAndView mav = new ModelAndView();

		if(result>0) { //글쓰기 성공시 리스트로
			mav.setViewName("redirect:freeBoard2");
		}else {//글쓰기 폼으로
			mav.setViewName("redirect:freeboardWrite");
		}
		return mav;
	}		

	// vo.setIp(req.getRemoteAddr());*/
	//vo.setM_userid((String)ses.getAttribute("login"));
	/* vo.setM_nickname((String)ses.getAttribute("lognickname")); */
	//vo.setM_userid((String)req.getSession().getAttribute("m_userid"));
	//	  vo.setM_nickname((String)req.getSession().getAttribute("m_nickname"));
	//	  vo.setBoard_subject((String)req.getSession().getAttribute("board_subject"));

	//수정폼
	@RequestMapping("/freeEdit")
	public ModelAndView boardEdit(int board_seq){
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo",	boardService.freeView(board_seq)); //boardservice에 레코드번호 넣어서 바로 대입
		mav.setViewName("board/freeEdit");
		return mav;
	}

	//글수정(수정되면 글내용보기)
	@RequestMapping(value="/freeEditOk", method=RequestMethod.POST)
	public ModelAndView boardEditOk(BoardVO vo, HttpSession session){
		vo.setM_userid((String)session.getAttribute("login"));
		vo.setM_seq(Integer.parseInt((String)session.getAttribute("logseq"))); 
		/* vo.setM_nickname((String)session.getAttribute("lognickname")); */
//		 vo.setM_seq(Integer.parseInt((String)ses.getAttribute("logseq"))); 
		System.out.println(vo.getM_userid());
		System.out.println(vo.getM_seq());
		
		int result = boardService.freeUpdate(vo);

		ModelAndView mav = new ModelAndView();
		if(result>0) { //수정된 경우
			mav.addObject("board_seq", vo.getBoard_seq());
			mav.setViewName("redirect:freeview");
			System.out.println("수정됨");
		}else { //실패
			mav.setViewName("board/result"); //이전페이지로 이동(레코드 번호 필요x)
			System.out.println("수정실패");
		}
		return mav;	
	}

	//글삭제
	@RequestMapping(value="/freeDelete")
	public ModelAndView freeDelete(int board_seq, HttpSession ses) {
		
		/* vo.setM_seq(Integer.parseInt((String)ses.getAttribute("logseq"))); */
		String userid= (String)ses.getAttribute("login"); //세션에 있는 아이디 필요
		
		int result = boardService.freeDelete(board_seq, userid);
		ModelAndView mav = new ModelAndView();
		if(result>0) {//삭제가 되면 리스트로
			mav.setViewName("redirect:freeBoard2");
		}else { //삭제 못했을 경우 글내용보기로
			mav.addObject("board_seq", board_seq); //레코드 번호가 필요하니가 가져가야함
			mav.setViewName("redirect:freeview");
		}
		return mav;
	}
	
	

	
	//댓글 쓰기
	
	
	//댓글 목록
	@RequestMapping(value="/commentList")
	public ModelAndView commentList(int board_seq) {
		ModelAndView mav = new ModelAndView();
		/* vo.setM_userid((String)session.getAttribute("login")); */
		
		mav.addObject("list", boardService.commentList(board_seq));
		mav.setViewName("/board/freeview");
		return mav;
	}


	/*
	 * @RequestMapping("/freeBoard2") public String freeboardWrite() { return
	 * "board/freeBoard2"; }
	 * 
	 */
	/*
	 * @RequestMapping("/board/freeBoard2") public ModelAndView freeBoard2(PagingVO
	 * pVo) { ModelAndView mav = new ModelAndView(); //총레코드수
	 * boardService.totalRecordCount(pVo); mav.addObject("pVo",pVo);
	 * mav.addObject("list", boardService.boardPageSelect(pVo));
	 * mav.setViewName("board/freeBoard2"); return mav; }
	 * 
	 * //자유게시판 글쓰기
	 * 
	 * @RequestMapping("/board/freeboardWrite") public String freeboardWrite() {
	 * return "board/freeboardWrite"; }
	 */

	/*
	 * //자유게시판 글쓰기 등록시
	 * 
	 * @RequestMapping(value="/board/freeWriteOk",method=RequestMethod.POST ) public
	 * ModelAndView freeWriteOk(BoardVO vo, HttpServletRequest req) {
	 * vo.setIp(req.getRemoteAddr());
	 * vo.setUserid((String)req.getSession().getAttribute("m_userid"));
	 * 
	 * int result = boardService.freeboardWrite(vo); ModelAndView mav = new
	 * ModelAndView(); mav.setViewName("redirect:freeBoard2"); //board/list로 return
	 * mav;
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping("/board/view") public ModelAndView boardView(int no) {
	 * ModelAndView mav = new ModelAndView(); mav.addObject("vo",
	 * boardService.boardView(no)); mav.setViewName("board/view"); return mav; }
	 */

	/*
	 * @RequestMapping("/freeBoard2") public ModelAndView freeBoard2() {
	 * ModelAndView mav = new ModelAndView(); mav.addObject("list",
	 * boardService.boardList()); mav.setViewName("board/freeBoard2");
	 * 
	 * return mav; }
	 */
	/*
	 * @RequestMapping("/freeBoard2") public String freeBoard2() { return
	 * "board/freeBoard2"; }
	 * 
	 * @RequestMapping("/freeboardWrite") public String freeBoard2() { return
	 * "board/freeboardWrite"; }
	 */



}
