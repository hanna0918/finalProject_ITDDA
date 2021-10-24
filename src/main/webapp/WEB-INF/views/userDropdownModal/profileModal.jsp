<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <!-- ---------------프로필 모달창-------------- -->
       <div class="profilJoinModal" id="profilJoinModal">
            <article class="profilModalContent profilDataInputModal" style="box-shadow: 5px 5px 5px lightgrey; width:320px;">
               <div id="test">
               <h1>PROFILE</h1>
                     <h4 id="profileTop">🍊&nbsp;프로필</h4>
            <%--    <form>
                  <!--    <a><img src="..//itda/img/close1.png" class="close7" 
                       style="position:absolute;top: 10px; right: 16px;;"/></a> -->
                       <div class="profileinfo">
                          <div>
                             <div style="width:100px; height:100px; margin:0 auto;"> <!-- padding -->
                                <img src="/itda/img/moveprofile.gif"/>
                             </div>
                          </div>
                          <div>${vo.m_username } &nbsp;( ${vo.m_userid} )</div>
                          <div>Female</div>
                          <div>브론즈</div>
                       </div>
                       
                       <div class="profilFoot" style="padding:10px;">
                       <li id="profileHi">인사말</li>
                       <input type="text" placeholder="인사말" />
                       
                       <li id="profileLike">관심분야</li>
                       <input type="text" placeholder="관심분야 " />
                       
                       <input type="button" value="확인" id="profilebtn" style="margin-top: 20px; width: 100%;"/>
                       </div>
                          
                       <!-- <div><input type="button" value="확인"/></div> -->
                    </form>  --%>
                    
                    
               </div>
            </article>
      </div> 