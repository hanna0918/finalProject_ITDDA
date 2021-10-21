package com.finalproject.itda.vo;

public class BoardCommentVO {
	private int br_id;
	private int board_seq;
	private int m_seq;
	private String br_content;
	private String br_writedate;
	private String m_userid;
	
	//湲��젣紐�
	private String board_subject;
	//�땳�꽩
	private String m_nickname;
	//爾뚮컯 諛곗뿴
	private int[] br_id_Array;
	
	
	public int getBr_id() {
		return br_id;
	}
	public void setBr_id(int br_id) {
		this.br_id = br_id;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	public String getBr_writedate() {
		return br_writedate;
	}
	public void setBr_writedate(String br_writedate) {
		this.br_writedate = br_writedate;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int[] getBr_id_Array() {
		return br_id_Array;
	}
	public void setBr_id_Array(int[] br_id_Array) {
		this.br_id_Array = br_id_Array;
	}
	
	
	
}
