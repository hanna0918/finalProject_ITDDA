<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!-- --------------구독 모달창-------------- -->
      <div class="gudokJoinModal" id="gudokJoinModal">
            <article class="gudokModalContent gudokDataInputModal">
               <div>
                  <h4> 구독하시겠습니까? </h4>
                  <input type="submit" value="네, 구독할래요." id="yesGudok"  />
                  <input type="button" value="취소" id="noGudok" />
                   
                  <a><img src="/itda/img/close1.png" class="close5" 
                    style="position:absolute;top: 10px; right: 17px;"/></a>
                    <!-- <div><input type="button" value="확인"/></div> -->
               </div>
            </article>
      </div>
      