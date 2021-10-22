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
	//   @RequestMapping(value="/matchingListTagSearch", method=RequestMethod.POST)
	//   @ResponseBody
	//   public List<MatchingVO> tagSearch(PagingVO pVo){
	//      matchingService.page(pVo);
	//      return matchingService.matchingList(pVo);
	//   } 
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
		int cnt = matchingService.countHit(board_seq);

		mav.addObject("vo", matchingService.matchingView(board_seq));
		mav.setViewName("matching/matchingView");
		return mav;
	}
	
	@RequestMapping("/matchingUpload")
	public String matchingUpload(HttpSession ses) {
		System.out.println("세션은" + ses.getAttribute("login"));
		if(ses.getAttribute("login") != null) {
			return "matching/matchingUpload";
		} else {
			System.out.println("여기들어옴");
			return "register/login";
		}
	}

	@RequestMapping(value="/matchingWriteOk", method = RequestMethod.POST)
	public ModelAndView matchingWriteOk(MatchingVO vo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("vo", vo);
//			map.put("m_seq", (Integer)ses.getAttribute("logseq"));
			int result = matchingService.matchingWriteOk(vo);
			System.out.println("너 뭐냐"+result);
//			mav.setViewName("redirect:matchingList");
			mav.setViewName("redirect:matchingList");
		return mav;
	}

	@RequestMapping("/matchingEdit")
	public ModelAndView matchingEdit(int board_seq, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		Object test = ses.getAttribute("logseq");

		matchingService.matchingEdit(board_seq, Integer.valueOf((String)test) );
		return mav;
	}
	
//	@RequestMapping("/matchingReply")
//	@ResponseBody
//	public List<>
}