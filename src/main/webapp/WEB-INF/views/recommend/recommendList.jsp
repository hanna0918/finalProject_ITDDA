<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/recommend.css" />
<div class="boardContainer" style="overflow:visible;">

   <!-- 게시판제목 -->
   <!-- 검색창 -->

   <header>
   <div class="boardName">
      <h2>RECOMMEND</h2>
      <h4>모두에게 유용한 정보를 추천해보세요!</h4>
   </div>
      <div id="recommendSerchBox">
         <form method="post" id="tagTranfer" onsubmit="return false">
            <div>
               <input type="text" name="searchText" id="searchText" placeholder="#태그를 입력하세요."/>
            </div>
		<div id="tagAndDate">
            <div id="addTag">
               <div id="hiddenTag0" ></div>
               <div id="hiddenTag1" ></div>
               <div id="hiddenTag2" ></div>
               <div id="hiddenTag3" ></div>
               <div id="hiddenTag4" ></div>
            </div>
        </div>
         </form>
      </div>
   </header>

   <div>
      <form>
         <div class="chucheonList">
            <!-- 추천 리스트 start-------------------------------------------------->
            <c:forEach var="vo" items="${list}">
               <div>${vo.board_seq}</div>
               <div class="recommendContent">
                  <div>
                     ${vo.thumbImg} style="width: 120px;" class="chucheonImg" />
                  </div>
                  <div class="contentInfo">
                     <!-- 2 -->
                     <div>
                        <a href="/itda/recommendView?board_seq=${vo.board_seq}">${vo.board_subject}</a>
                     </div>
                     <span class="tagspan"><c:forEach var="tag" items="${vo.tags}">#${tag} </c:forEach></span>
                     <div>
                        <div>${vo.m_nickname}</div>
                        <div>${vo.board_writedate}</div>
                        <div>조회수 ${vo.board_hit}</div>
                        <div>
                           <img src="img/recommend.png" class="recommendImg" /> <span>${vo.b_goodhit}</span>
                        </div>
                        <div>
                           <img src="img/siren3.png" class="commentImg" /> <span>${vo.board_call}</span>
                        </div>
                     </div>
                  </div>
               </div>
               <!-- 3 -->
               <div>
                  <img src="img/replImg.png" class="commentImg" /> ${vo.br_cnt}
               </div>
            </c:forEach>
         </div>
         <!-- 추천 리스트 end-------------------------------------------------->
      </form>
   </div>

</div>

<div style="width:1200px; margin:0 auto;">
   <!-- 글쓰기 버튼 -->
   <div class="boardBtnDiv">
      <input type="button" value="글쓰기" class="writeBtn recommendBtn"
         onclick="location.href='/itda/recommendWrite'" />
   </div>
   <!-- 페이지번호 -->
   <div class='pagingDiv'>
      <ul>
         <c:if test="${pVo.nowPage>1}">
            <li class='page-item'><a href="javascript:recommendPaging(${pVo.nowPage-1})" class='page-link'>◁</a></li>
         </c:if>
         <c:if test="${pVo.nowPage==1 }">
            <li class='page-item'><a class='page-link'>◁</a></li>
         </c:if>
         <c:forEach var="i" begin="${pVo.startPage}" end="${pVo.startPage+pVo.onePageNumCount-1}">
            <c:if test="${i<=pVo.totalPage}">
               <c:if test="${i==pVo.nowPage}">
                  <li class='page-item' id="activePage">
               </c:if>
               <c:if test="${i!=pVo.nowPage}">
                  <li class='page-item'>
                </c:if>
             <a href="javascript:recommendPaging(${i} , ${pVo.totalPage} , ${pVo.onePageNumCount} , ${pVo.totalRecord})">${i}</a></li>
          </c:if>
      </c:forEach>
      <c:if test="${pVo.nowPage<pVo.totalPage}">
          <li class='page-item'><a href="javascript:recommendPaging(${pVo.nowPage+1})">▷</a></li>
       </c:if>
      </ul>
   </div>
</div>
<script defer type="text/javascript" src="js/recommend.js"></script>