package com.finalproject.itda.vo;

public class MemberBaseVO {
	private int m_seq;
	private String m_userid;
	private String m_userpwd;
	private String m_username;
	private String m_nickname;
	private String m_tel;
	private String m_email;
	private String m_addr;
	private String m_bith;
	private String m_info;
	private String m_gender;
	private String m_tag;
	private String m_regdate;
	private int m_statecode;
	private int m_rank;
	
	private String m_addrdetail;
	private String m_birth;
	private String m_img;
	private String b_note;//차단사유
	private String msg_content; // 쪽지내용
	
//	조인용 vo
	private String m_content;
	private String board_seq; 
	private String m_name;  
	private String m_state;
	
	
	//카운트용
	private int board_count;
	private int comment_count;
	private int sub_count;
	private int bookmark_count;
	private int msg_count;
	
	

	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getM_addrdetail() {
		return m_addrdetail;
	}
	public void setM_addrdetail(String m_addrdetail) {
		this.m_addrdetail = m_addrdetail;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getM_userpwd() {
		return m_userpwd;
	}
	public void setM_userpwd(String m_userpwd) {
		this.m_userpwd = m_userpwd;
	}
	public String getM_username() {
		return m_username;
	}
	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public String getM_bith() {
		return m_bith;
	}
	public void setM_bith(String m_bith) {
		this.m_bith = m_bith;
	}
	public String getM_info() {
		return m_info;
	}
	public void setM_info(String m_info) {
		this.m_info = m_info;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public String getM_tag() {
		return m_tag;
	}
	public void setM_tag(String m_tag) {
		this.m_tag = m_tag;
	}
	public String getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(String m_regdate) {
		this.m_regdate = m_regdate;
	}
	public int getM_statecode() {
		return m_statecode;
	}
	public void setM_statecode(int m_statecode) {
		this.m_statecode = m_statecode;
	}
	public int getM_rank() {
		return m_rank;
	}
	public void setM_rank(int m_rank) {
		this.m_rank = m_rank;
	}
	public String getM_birth() {
		return m_birth;
	}
	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public String getB_note() {
		return b_note;
	}
	public void setB_note(String b_note) {
		this.b_note = b_note;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_state() {
		return m_state;
	}
	public void setM_state(String m_state) {
		this.m_state = m_state;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getSub_count() {
		return sub_count;
	}
	public void setSub_count(int sub_count) {
		this.sub_count = sub_count;
	}
	public int getBookmark_count() {
		return bookmark_count;
	}
	public void setBookmark_count(int bookmark_count) {
		this.bookmark_count = bookmark_count;
	}
	public int getMsg_count() {
		return msg_count;
	}
	public void setMsg_count(int msg_count) {
		this.msg_count = msg_count;
	}
}
