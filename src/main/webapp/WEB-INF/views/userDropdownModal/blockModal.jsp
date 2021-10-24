<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!---------------- 차단 모달창 ------------- -->
      <div class="blockJoinModal" id="blockJoinModal">
            <article class="blockModalContent blockDataInputModal">
               <div>
                  
                  <h4>차단하면 서로의 게시글을 볼 수 없고, 서로 쪽지도 <br/>보낼 수 없어요.&nbsp; 차단하시겠습니까?</h4>
                  <input type="submit" value="네, 차단할래요." id="yesChadan" />
                  <input type="button" value="취소" id="noChadan"/>
                  
                  <a><img src="/itda/img/close1.png" class="close1" 
                    style="position:absolute;top: 10px; right: 17px;"/></a>
                    <!-- <div><input type="button" value="확인"/></div> -->
               </div>
            </article>
      </div>