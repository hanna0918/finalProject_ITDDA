package com.finalproject.itda.vo;

public class BoardVO {
	private int m_seq; //회원번호 
	private int board_seq; //게시물번호
	private int board_code;//카테고리 번호
	private String board_subject; //제목
	private String board_writedate; //등록일
	private int board_hit; //조회수
	private int b_goodhit;//좋아요
	private int board_call; //신고
	private int board_black; //블럭처리
	private String m_userid; //아이디
	private String m_nickname;//닉네임
	private int commentcount; //댓글수 
	private int br_id; //댓글번호
	private String b_content;
	private String board_blockcontent;
	private String board_content;
	private String m_name; // 등급이름 

	private int board_block;

	
	//댓글 수 
	private int br_count;
	//--닉네임 관리--
	//--닉네임 관리--
	//--카테고리 관리--
	//--카테고리 관리--

	//--장터 관리--
	private String board_shopcontent;
	//--장터 관리--
	//--태그 관리--
	private String board_select;
	//--태그 관리--
	//--이미지 관리--
	private int imageseq;
	private String l_Url;
	
	
	
	
	public int getBoard_block() {
		return board_block;
	}
	public void setBoard_block(int board_block) {
		this.board_block = board_block;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_blockcontent() {
		return board_blockcontent;
	}
	public void setBoard_blockcontent(String board_blockcontent) {
		this.board_blockcontent = board_blockcontent;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_writedate() {
		return board_writedate;
	}
	public void setBoard_writedate(String board_writedate) {
		this.board_writedate = board_writedate;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public int getB_goodhit() {
		return b_goodhit;
	}
	public void setB_goodhit(int b_goodhit) {
		this.b_goodhit = b_goodhit;
	}
	public int getBoard_call() {
		return board_call;
	}
	public void setBoard_call(int board_call) {
		this.board_call = board_call;
	}
	public int getBoard_black() {
		return board_black;
	}
	public void setBoard_black(int board_black) {
		this.board_black = board_black;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public int getCommentcount() {
		return commentcount;
	}
	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}
	public int getBr_id() {
		return br_id;
	}
	public void setBr_id(int br_id) {
		this.br_id = br_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getBr_count() {
		return br_count;
	}
	public void setBr_count(int br_count) {
		this.br_count = br_count;
	}
	public String getBoard_shopcontent() {
		return board_shopcontent;
	}
	public void setBoard_shopcontent(String board_shopcontent) {
		this.board_shopcontent = board_shopcontent;
	}
	public String getBoard_select() {
		return board_select;
	}
	public void setBoard_select(String board_select) {
		this.board_select = board_select;
	}
	public int getImageseq() {
		return imageseq;
	}
	public void setImageseq(int imageseq) {
		this.imageseq = imageseq;
	}
	public String getL_Url() {
		return l_Url;
	}
	public void setL_Url(String l_Url) {
		this.l_Url = l_Url;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	

}

