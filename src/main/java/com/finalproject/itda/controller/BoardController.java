package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.List;
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
import com.finalproject.itda.vo.MemberBaseVO;
import com.finalproject.itda.vo.PagingVO;

@Controller
public class BoardController {
	@Inject
	BoardService boardService;


	//자유게시판 리스트 /////////////////////////origin
	 @RequestMapping("/freeBoard2") //, value= method = RequestMethod.GET public
	 public String freeBoard2(PagingVO pVo, Model model){
		 model.addAttribute("list",boardService.boardList(pVo));
		 return "board/freeBoard2"; 
	 }
	 
	 //프로필 모달 
	 @RequestMapping(value="/freeBoardmodal" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberBaseVO freeBoardmodal(MemberBaseVO mbVo) {
		 MemberBaseVO resultvo = boardService.freeBoardmodal(mbVo);
		return resultvo;
	
	 }
	 //차단 모달
//	 @RequestMapping(value="/freeBoardmodalChadan" , method=RequestMethod.POST )
//	 @ResponseBody
//	 public MemberBaseVO freeBoardmodalChadan(MemberBaseVO mbVo) {
//		 System.out.println("들어온거 맞니? 차단?");
//		 System.out.println(mbVo.getM_nickname());
//		
//		 MemberBaseVO resultvo = boardService.freeBoardmodal(mbVo);
//			return resultvo;
//	 }
	 
	 //차단 ok 모달 (insert 새로 만든거)
	 @RequestMapping(value="/freeBoardmodalChadanOk", method=RequestMethod.POST)
	 @ResponseBody
	 public int freeBoardmodalChadanOk(MemberBaseVO mbVo) {
		 System.out.println("들어온거 맞니? 차단ok?");
		 System.out.println(mbVo.getM_nickname());
		 int result = boardService.freeBoardmodalChadanOk(mbVo);
		 System.out.println("db작업 끝 리턴 직전");
		 return result;
	 }
	
	 //구독 모달
	 @RequestMapping(value="/freeBoardmodalGudok" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberBaseVO freeBoardmodalGudok(MemberBaseVO mbVo) {
		 System.out.println("들어온거 맞니? 구독?");
		 System.out.println(mbVo.getM_nickname());
		 MemberBaseVO resultvo = boardService.freeBoardmodalGudok(mbVo);
		return resultvo;
	 }
	 
	 //구독 모달 ok (insert 새로 만든거)
	 @RequestMapping(value="/freeBoardmodalGudokOk" , method=RequestMethod.POST )
	 @ResponseBody
	 public int freeBoardmodalGudokOk(MemberBaseVO mbVo) {
		 System.out.println("들어온거 맞니? 구독 ok?");
		 System.out.println(mbVo.getM_nickname());
		 int result = boardService.freeBoardmodalGudokOk(mbVo);
		 System.out.println("dao까지는 문제 없음");
		return result;
	 }
	 
	 
	 
	//쪽지보내기 모달
	 @RequestMapping(value="/freeBoardmodalNote" , method=RequestMethod.POST )
	 @ResponseBody
	 public MemberBaseVO freeBoardmodalNote(MemberBaseVO mbVo) {
		 System.out.println("들어온거 맞니? 쪽지?");
		 System.out.println(mbVo.getM_nickname());
		 System.out.println();
		 MemberBaseVO resultvo = boardService.freeBoardmodalNote(mbVo);
			return resultvo;
	 }
	 //쪽지보내기 모달 yes
	 @RequestMapping(value="/freeBoardmodalNoteYes", method=RequestMethod.POST )
	 @ResponseBody
	 public int freeBoardmodalNoteYes(MemberBaseVO mbVo, HttpSession ses) {
		 System.out.println("이 ?");
		 System.out.println(mbVo.getM_nickname());
		 mbVo.setM_userid((String)ses.getAttribute("login"));
		 int result = boardService.freeBoardmodalNoteYes(mbVo);
			return result;
	 }
	 
	/*
	 * @RequestMapping(value="/freeBoard2") public String freeBoard2(Model model) {
	 * model.addAttribute("list", boardService.boardList()); return
	 * "/board/freeBoard2"; }
	 */
	
	//게시물보기
	 @RequestMapping(value = "/writeList", method=RequestMethod.GET)
		public String writeList(BoardVO vo, Model model) {
			model.addAttribute("m_nickname", vo.getM_nickname());
//			model.addAttribute("m_rank", vo.getM_rank());
		
			List<BoardVO> result = boardService.writeList(vo);
			
			model.addAttribute("list", result);
		
			//	
			/*m
			 * model.addAttribute("m_rank",vo.getM_rank()); model.addAttribute("m_nickname",
			 * vo.getM_nickname());
			 */

			return "/board/writeList";
		}
 
	/*
	 * //게시물보기 (//닉네임, 등급)
	 * 
	 * @RequestMapping(value="/freeBoardWriteView", method=RequestMethod.POST )
	 * 
	 * @ResponseBody public MemberBaseVO freeBoardWriteView(MemberBaseVO mbVo) {
	 * System.out.println("들어온거 맞니? 게시물보기?");
	 * System.out.println(mbVo.getM_nickname());
	 * System.out.println(mbVo.getM_name()); System.out.println(); MemberBaseVO
	 * resultvo = boardService.freeBoardmodalNote(mbVo); return resultvo; }
	 */
	 
	//글내용보기
	@RequestMapping("/freeview")
	public String boardView(Model model, int board_seq) {
		boardService.hitCount(board_seq);
		model.addAttribute("vo",boardService.freeView(board_seq));
		return "board/freeview";
	}

	//글쓰기 폼 
	@RequestMapping("/freeboardWrite") 
	public String freeboardWrite() {
		return "board/freeboardWrite";
	}
	
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
	
	//댓글 목록
	@RequestMapping(value="/commentList")
	public ModelAndView commentList(int board_seq) {
		ModelAndView mav = new ModelAndView();
		/* vo.setM_userid((String)session.getAttribute("login")); */
		
		mav.addObject("list", boardService.commentList(board_seq));
		mav.setViewName("/board/freeview");
		return mav;
	}
	
	//검색
	@RequestMapping(value="/test", method=RequestMethod.POST )
    public ModelAndView SerachFreeboard2(BoardVO vo)
    {
       ModelAndView mav = new ModelAndView();
        mav.addObject("list",boardService.freeViewSerch(vo));
        System.out.println(vo.getSearchkeyword());
        System.out.println(vo.getKeywordselect());
       mav.setViewName("board/freeBoard2");
       return mav;
    }


}
