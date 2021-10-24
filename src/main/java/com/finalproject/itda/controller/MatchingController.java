package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MatchingService;
import com.finalproject.itda.vo.BoardCommentVO;
import com.finalproject.itda.vo.CalendarVO;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.MatchingVO;

@Controller
public class MatchingController {
	@Inject
	MatchingService matchingService;
	@RequestMapping("/matchingList")
	public ModelAndView matchingList(MatchingVO vo) {
		ModelAndView mav = new ModelAndView();
		MatchingPagingVO pVo = new MatchingPagingVO();
		mav.setViewName("matching/matchingList");
		
		mav.addObject("pVo", matchingService.page(pVo));
		mav.addObject("list", matchingService.matchingList(pVo));
		return mav; 
	}

	@RequestMapping(value="/matchingListTagSearch", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tagSearch(MatchingPagingVO pVo){
		Map<String, Object> map = new HashMap<String, Object>();
		MatchingPagingVO ppVo = matchingService.page(pVo);
		ppVo.setNowPage(pVo.getNowPage());
		map.put("pVo", ppVo);
		map.put("vo", matchingService.matchingList(pVo));
		return map;
	}
	@RequestMapping("/calendarAjax")
	@ResponseBody
	public List<CalendarVO> calendarAjax() {
		return matchingService.dataForJson();
	}

	@RequestMapping(value="matchingView")
	public ModelAndView matchingView(int board_seq) {
		ModelAndView mav = new ModelAndView();
		matchingService.countHit(board_seq);
		mav.addObject("part", matchingService.matchingUser(board_seq));
		mav.addObject("vo", matchingService.matchingView(board_seq));
		mav.setViewName("matching/matchingView");
		return mav;
	}
	
	// 매칭 글쓰기폼 이동
	@RequestMapping("/matchingUpload")
	public String matchingUpload(HttpSession ses) {
		if(ses.getAttribute("login") != null) {
			return "matching/matchingUpload";
		} else {
			return "register/login";
		}
	}

	// 매칭 글쓰기 업로드
	@RequestMapping(value="/matchingWriteOk", method = RequestMethod.POST)
	public ModelAndView matchingWriteOk(MatchingVO vo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		int result = matchingService.matchingWriteOk(vo);
		if(result > 0) {
			mav.setViewName("redirect:matchingList");
		} else {
			mav.setViewName("matching/result");
		}
		return mav;
	}

	// 매칭 수정폼 이동
	@RequestMapping(value="/matchingEdit", method=RequestMethod.GET)
	public ModelAndView matchingEdit(int board_seq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", matchingService.matchingEdit(board_seq));
		mav.setViewName("matching/matchingEdit");
		return mav;
	}
	
	// 글 수정 후 update 하러 들어오는 메소등
	@RequestMapping(value="/matchingEditOk", method=RequestMethod.POST)
	public String matchingEditOk(MatchingVO vo) {
		matchingService.matchingEditOk(vo);
		return "redirect:matchingView?board_seq=" + vo.getBoard_seq();
	}
	
	// 매칭 참가중인지 확인하는 AJAX
	@RequestMapping("/matchingConfirm")
	@ResponseBody
	public MatchingVO matchingConfirm(int mc_seq, int m_seq){
		return matchingService.matchingConfirm(mc_seq, m_seq);
	}
	
	// 매칭 참가
	@RequestMapping("/matchingIn")
	public String matchingIn(int m_seq, int mc_seq, int board_seq) {
		matchingService.matchingIn(m_seq, mc_seq);
		return "redirect:/matchingView?board_seq="+board_seq;
	}
	
	// 매칭 취소
	@RequestMapping("/matchingCancel")
	public String matchingCancel(int m_seq, int mc_seq, int board_seq) {
		matchingService.matchingCancel(m_seq, mc_seq);
		return "redirect:/matchingView?board_seq="+board_seq;
	}
	
	// 댓글 목록
	@RequestMapping("/matchingReply")
	@ResponseBody
	public List<BoardCommentVO> matchingReply(int board_seq){
		return matchingService.matchingReply(board_seq);
	}
	
	// 댓글 등록
	@RequestMapping(value="/matchingReplyWrite", method=RequestMethod.POST)
	@ResponseBody
	public int matchingReplyWrite(BoardCommentVO vo) {
		return matchingService.matchingReplyWrite(vo);
	}
	
	// 댓글 수정
	@RequestMapping(value="/matchingReplyEdit", method=RequestMethod.POST)
	@ResponseBody
	public int MatchingReplyEdit(BoardCommentVO vo) {
		return matchingService.matchingReplyEdit(vo);
	}

	// 댓글 삭제
	@RequestMapping(value="/matchingReplyDelete", method=RequestMethod.POST)
	@ResponseBody
	public int MatchingReplyDelete(BoardCommentVO vo) {
		return matchingService.matchingReplyDelete(vo);
	}
	

}