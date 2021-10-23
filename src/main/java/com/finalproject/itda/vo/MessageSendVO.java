package com.finalproject.itda.vo;

public class MessageSendVO {
	private int message_sendcode; // 보낸 메세지 코드
	private String me_writedate; //쪽지보낸시간
	private String me_content; //쪽지내용
	private int m_ssq1; //보낸사람(회원번호)
	private int m_ssq2; //받는사람
	
	public int getMessage_sendcode() {
		return message_sendcode;
	}
	public void setMessage_sendcode(int message_sendcode) {
		this.message_sendcode = message_sendcode;
	}
	public String getMe_writedate() {
		return me_writedate;
	}
	public void setMe_writedate(String me_writedate) {
		this.me_writedate = me_writedate;
	}
	public String getMe_content() {
		return me_content;
	}
	public void setMe_content(String me_content) {
		this.me_content = me_content;
	}
	public int getM_ssq1() {
		return m_ssq1;
	}
	public void setM_ssq1(int m_ssq1) {
		this.m_ssq1 = m_ssq1;
	}
	public int getM_ssq2() {
		return m_ssq2;
	}
	public void setM_ssq2(int m_ssq2) {
		this.m_ssq2 = m_ssq2;
	}
	
	
	
	
	
	
}
