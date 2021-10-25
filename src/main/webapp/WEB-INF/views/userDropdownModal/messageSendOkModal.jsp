<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!------------------- 쪽지 전송 yes 모달창-----------------> 
       
          <div class="mailJoinModal2" id="mailJoinModal2">
            <article class="mailModalContent2 mailDataInputModal2" style="width: 315px; padding:0;">
               <div>
                  <div style="background: cornflowerblue; height: 25px;"></div>
                  <h4><strong>'${m_userid }'</strong>님에게 쪽지가 전송되었습니다 😊</h4>
                  
                  <a><img src="/itda/img/close1.png" class="close4" 
                    style="position:absolute;top: 0px; right: 1px;;"/></a>
                 
                    <!-- <div><input type="button" value="확인"/></div> -->
               </div>
            </article>
      </div>
       