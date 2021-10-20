package com.finalproject.itda.vo;

public class RecommendVO {
	private	int board_seq;				//게시물 번호
	private int m_seq;					//회원 번호
	private int board_code;				//카테고리 번호
	private String board_subject;		//제목
	private String board_writedate;		//등록일
	private int board_hit;				//조회수
	private int b_goodhit;				//좋아요
	private int board_call;				//신고
	private int board_block;			//블럭처리
	private String board_blockcontent;	//블럭처리내용
	private String b_content;			//글내용
	
	//태그
	private String board_select;		//태그
	
	//댓글
	private int br_id;					//댓글번호
	private String br_content;			//댓글내용
	private String br_writedate;		//댓글등록일
	private String br_cnt;				//댓글 갯수 - 서브쿼리문용(select문)
	
	
	//이미지
	private int imageseq;				//이미지번호
	private String i_url;				//이미지제목? 경로?
	
	//회원정보
	private String m_userid;			//아이디
	private String m_nickname;			//닉네임
	
	
	
	
	
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
	public String getBr_cnt() {
		return br_cnt;
	}
	public void setBr_cnt(String br_cnt) {
		this.br_cnt = br_cnt;
	}
	public int getImageseq() {
		return imageseq;
	}
	public void setImageseq(int imageseq) {
		this.imageseq = imageseq;
	}
	public String getI_url() {
		return i_url;
	}
	public void setI_url(String i_url) {
		System.out.println(i_url);
		this.i_url = i_url;
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
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		System.out.println(board_code);
		this.board_code = board_code;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		System.out.println(board_subject);
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
	public int getBoard_block() {
		return board_block;
	}
	public void setBoard_block(int board_block) {
		this.board_block = board_block;
	}
	public String getBoard_blockcontent() {
		return board_blockcontent;
	}
	public void setBoard_blockcontent(String board_blockcontent) {
		this.board_blockcontent = board_blockcontent;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getBoard_select() {
		return board_select;
	}
	public void setBoard_select(String board_select) {
		this.board_select = board_select;
	}
	public int getBr_id() {
		return br_id;
	}
	public void setBr_id(int br_id) {
		this.br_id = br_id;
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
	
	
	
	
	
}
