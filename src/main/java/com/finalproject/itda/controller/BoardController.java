package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.BoardService;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberbaseVO;
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

	//자유게시판 리스트 /////////////////////////origin
	
	 @RequestMapping("/freeBoard2") //, value= method = RequestMethod.GET public
	 public String freeBoard2(PagingVO pVo, Model model){
		 model.addAttribute("list",boardService.boardList(pVo));
		 return "board/freeBoard2"; 
	 }
	 
	////////////////////////////////////////////////////////////
	
	 //프로필 모달 
	 @RequestMapping(value="/freeBoardmodal" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberbaseVO freeBoardmodal(MemberbaseVO mbVo) {
			/*
			 * System.out.println(mbVo.getM_nickname());
			 * System.out.println("들어온거 맞니? 프로필?"); System.out.println(mbVo.getM_name());
			 * System.out.println(mbVo.getM_gender()); System.out.println(mbVo.getM_info());
			 * System.out.println(mbVo.getM_tag());
			 */
		 MemberbaseVO resultvo = boardService.freeBoardmodal(mbVo);
		return resultvo;
	
	 }
	 
	 
	 //차단 모달
	 @RequestMapping(value="/freeBoardmodalChadan" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberbaseVO freeBoardmodalChadan(MemberbaseVO mbVo) {
		 System.out.println("들어온거 맞니? 차단?");
		 System.out.println(mbVo.getM_nickname());
		 MemberbaseVO resultvo = boardService.freeBoardmodal(mbVo);
			return resultvo;
	 }
	
	 //구독 모달
	 @RequestMapping(value="/freeBoardmodalGudok" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberbaseVO freeBoardmodalGudok(MemberbaseVO mbVo) {
		 System.out.println("들어온거 맞니? 구독?");
		 System.out.println(mbVo.getM_nickname());
		 MemberbaseVO resultvo = boardService.freeBoardmodal(mbVo);
		return resultvo;
	 }
	 
	//쪽지보내기 모달
	 @RequestMapping(value="/freeBoardmodalNote" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberbaseVO freeBoardmodalNote(MemberbaseVO mbVo) {
		 System.out.println("들어온거 맞니? 쪽지?");
		 System.out.println(mbVo.getM_nickname());
		 System.out.println();
		 MemberbaseVO resultvo = boardService.freeBoardmodal(mbVo);
			return resultvo;
	 }
	 //쪽지보내기 모달 yes
	 @RequestMapping(value="/ freeBoardmodalNoteYes" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberbaseVO freeBoardmodalNoteYes(MemberbaseVO mbVo) {
		 System.out.println("들어온거 맞니? 쪽지 yes?");
		 System.out.println(mbVo.getM_nickname());
		 System.out.println();
		 MemberbaseVO resultvo = boardService.freeBoardmodal(mbVo);
			return resultvo;
	 }
	 
	 
	 
	 
	 
	/*
	 * @RequestMapping(value="/freeBoard2") public String freeBoard2(Model model) {
	 * model.addAttribute("list", boardService.boardList()); return
	 * "/board/freeBoard2"; }
	 */
	
	
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

	/*
	 * @RequestMapping(value="/freeWriteOk",method=RequestMethod.POST ) public
	 * ModelAndView freeWriteOk(BoardVO vo, HttpSession ses, HttpServletRequest req)
	 * { vo.setM_seq(Integer.parseInt((String)ses.getAttribute("logseq"))); int
	 * result = boardService.freeboardWrite(vo); ModelAndView mav = new
	 * ModelAndView();
	 * 
	 * if(result>0) { //글쓰기 성공시 리스트로 mav.setViewName("redirect:freeBoard2"); }else
	 * {//글쓰기 폼으로 mav.setViewName("redirect:freeboardWrite"); } return mav; }
	 */
	
	@RequestMapping(value="/freeWriteOk",method=RequestMethod.POST ) 
	   public ModelAndView freeWriteOk(BoardVO vo, HttpSession ses) {
	      System.out.println("subject" + ses.getAttribute("logseq"));
	      System.out.println("subject" + vo.getBoard_subject());
	      System.out.println("content" +vo.getB_content());
	      System.out.println("sessiong"+ vo.getM_seq());

	      vo.setM_seq(Integer.parseInt(ses.getAttribute("logseq").toString()));
	      ModelAndView mav = new ModelAndView();
	      int result = boardService.freeboardWrite(vo);
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
		vo.setM_seq(Integer.parseInt(session.getAttribute("logseq").toString()));
		/* vo.setM_seq(Integer.parseInt((String)session.getAttribute("logseq"))); */
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", (String)ses.getAttribute("login"));
		map.put("board_seq", board_seq);
		int result = boardService.freeDelete(map);
		ModelAndView mav = new ModelAndView();
		if(result>0) {//삭제가 되면 리스트로
			mav.setViewName("redirect:freeBoard2");
		}else { //삭제 못했을 경우 글내용보기로
			mav.addObject("board_seq", board_seq); //레코드 번호가 필요하니가 가져가야함
			mav.setViewName("redirect:freeview");
		}
		return mav;
	}
	
	

	/*
	//댓글 쓰기
	@RequestMapping(value="/commentWrite", method=RequestMethod.POST) //view페이지에서 받아서 success로 리턴
	public int commentWrite(Model model,Board_CommentVO commentVo, HttpSession ses) {
		//댓글 작성자를 session 얻어오기
		model.addAttribute("commentVo",boardService.commentInsert(commentVo));
		commentVo.setM_seq((String)ses.getAttribute("logseq")); //object이니까 string으로 바꿔서
		return "board/freeview";
			
	}
	*/
	
	//댓글 목록
	@RequestMapping(value="/commentList")
	public ModelAndView commentList(int board_seq) {
		ModelAndView mav = new ModelAndView();
		/* vo.setM_userid((String)session.getAttribute("login")); */
		
		mav.addObject("list", boardService.commentList(board_seq));
		mav.setViewName("/board/freeview");
		return mav;
	}
	
	//게시물보기
	@RequestMapping("/writeList")
	public String writeList() {
		return "/board/writeList";
	}

	@RequestMapping("/test")
	public String test() {
		System.out.print("ASfsadf");
		return null;
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
