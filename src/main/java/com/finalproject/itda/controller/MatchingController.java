package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MatchingService;
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
//   @RequestMapping("/calendarAjax")
//   @ResponseBody
//   public String calendarAjax() {
//      List<CalendarVO> list = matchingService.dataForJson();
//      String json = new Gson().toJson(list);
//      json.split("\"mc_state\": 0,");
//      System.out.println(json);
//      return json;
//   }
   
   @RequestMapping(value="matchingView")
   public ModelAndView matchingView(int board_seq) {
      ModelAndView mav = new ModelAndView();
      int cnt = matchingService.countHit(board_seq);
      
      mav.addObject("vo", matchingService.matchingView(board_seq));
      mav.setViewName("matching/matchingView");
      return mav;
   }
   @RequestMapping("/matchingUpload")
   public String matchingUpload() {
      return "matching/matchingUpload";
   }
   @RequestMapping("/matchingEdit")
   public ModelAndView matchingEdit(int board_seq, HttpSession ses) {
      ModelAndView mav = new ModelAndView();
      matchingService.matchingEdit(board_seq, (int)ses.getAttribute("logseq"));
      return mav;
   }
}