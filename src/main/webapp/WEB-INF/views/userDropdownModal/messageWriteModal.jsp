<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

      <!-- ----------쪽지보내기 모달창------------------> 
      
      <div class="mailJoinModal" id="mailJoinModal">
            <article class="mailModalContent mailDataInputModal style="box-shadow: 10px 10px 5px lightgrey;" >
               <div>
                  <form>
                     <h4 style="background:moccasin;" >🍊 쪽지 보내기</h4>
                     <a><img src="/itda/img/close1.png" class="close3" 
                       style="position:absolute;top: 10px; right: 16px;;"/></a>
                       <ul class="mailInfo">
                          <li style="text-align: left; padding-left: 25px;">받는사람 &nbsp; : &nbsp; ${m_userid}</li>  
                          <li style="text-align: left; padding-left: 25px; padding-top: 10px;">내용</li>
                          <textarea class="mailTextarea" title="쪽지 내용을 입력하세요" placeholder="쪽지 내용을 입력하세요" style="margin:5px; width:325px; height:200px; resize:none; outline-style:none; padding:0; border-radius:3px 3px 0 0; font-size:14px; cursor:text">
                          </textarea>
                       </ul>
                          <input type="submit" value="보내기" id="yesMail"/>
                          <input type="button" value="취소" id="noMail"/>
                       <!-- <div><input type="button" value="확인"/></div> -->
                    </form>
               </div>
            </article>
      </div> 
       