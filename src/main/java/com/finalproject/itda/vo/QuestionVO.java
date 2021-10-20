package com.finalproject.itda.vo;

public class QuestionVO {
	private int q_number;	//문의번호
	private String q_category;	//문의 카테고리	
	private String q_title;	//문의내용
	private String q_date;	//등록일
	private String q_result;	//답변
	private int q_result_state;	//답변상태
	private int m_seq;	//회원번호
	
	
	public int getQ_number() {
		return q_number;
	}
	public void setQ_number(int q_number) {
		this.q_number = q_number;
	}
	public String getQ_category() {
		return q_category;
	}
	public void setQ_category(String q_category) {
		this.q_category = q_category;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public String getQ_result() {
		return q_result;
	}
	public void setQ_result(String q_result) {
		this.q_result = q_result;
	}
	public int getQ_result_state() {
		return q_result_state;
	}
	public void setQ_result_state(int q_result_state) {
		this.q_result_state = q_result_state;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	
	
}
