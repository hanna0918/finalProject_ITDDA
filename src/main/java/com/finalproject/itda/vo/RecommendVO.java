package com.finalproject.itda.vo;

public class RecommendVO {
	private int board_seq; // 게시물 번호
	private int m_seq; // 회원 번호
	private int board_code; // 카테고리 번호
	private String board_subject; // 제목
	private String board_writedate; // 등록일
	private int board_hit; // 조회수
	private int b_goodhit; // 좋아요
	private int board_call; // 신고
	private int board_block; // 블럭처리
	private String board_blockcontent; // 블럭처리내용
	private String b_content; // 글내용

	// 태그
	private String board_select; // 태그

	// 댓글
	private int br_id; // 댓글번호
	private String br_content; // 댓글내용
	private String br_writedate; // 댓글등록일
	private String br_cnt; // 댓글 갯수 - 서브쿼리문용(select문)

	// 이미지
	private int imageseq; // 이미지번호
	private String i_url; // 이미지제목? 경로?

	// 회원정보
	private String m_userid; // 아이디
	private String m_nickname; // 닉네임

	private String board_prev_subject;// 이전글
	private String board_next_subject;// 다음글

	
	private String tags[];
	private String prevTags[];
	private String nextTags[];
	
	
	private String mc_start_date;
	private String mc_end_date;
	private String mc_where;
	private String m_info;
	private String board_prev_select;
	private String board_next_select;
	private String startDate;
	private String startTime;
	private String endTime;
	private String sido;
	private String gugun;
	
	private int board_prev_seq;
	private int board_next_seq;
	private int mc_state;
	private int mc_max;
	private int m_rank;
	private int partCnt;
	private int mc_seq;
	private int matchingCount;
	private int replyCount;
	

	
	
	
	
	public int getBoard_code() {
		return board_code;
	}
	public void setBoard_code(int board_code) {
		this.board_code = board_code;
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
		this.i_url = i_url;
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
	public String getBoard_select() {
		return board_select;
	}
	public void setBoard_select(String board_select) {
		this.board_select = board_select;
		tags=board_select.split("/");
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
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
	public String getBoard_writedate() {
		return board_writedate;
	}
	public void setBoard_writedate(String board_writedate) {
		this.board_writedate = board_writedate;
	}
	public String getMc_start_date() {
		if(startDate != null) {
			mc_start_date = startDate + " " + startTime;
		}
		return mc_start_date;
	}
	public void setMc_start_date(String mc_start_date) {
		this.mc_start_date = mc_start_date;
	}
	public String getMc_end_date() {
		if(startDate != null) {
			mc_end_date = startDate + " " + endTime;
		}
		return mc_end_date;
	}
	public void setMc_end_date(String mc_end_date) {
		this.mc_end_date = mc_end_date;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getMc_where() {
		if(sido != null && gugun != null) {
			mc_where = sido + " " + gugun;
		}
		return mc_where;
	}
	public void setMc_where(String mc_where) {
		this.mc_where = mc_where;
	}
	public String getM_info() {
		return m_info;
	}
	public void setM_info(String m_info) {
		this.m_info = m_info;
	}
	public String getBoard_prev_subject() {
		return board_prev_subject;
	}
	public void setBoard_prev_subject(String board_prev_subject) {
		this.board_prev_subject = board_prev_subject;
	}
	public String getBoard_next_subject() {
		return board_next_subject;
	}
	public void setBoard_next_subject(String board_next_subject) {
		this.board_next_subject = board_next_subject;
	}
	public String getBoard_prev_select() {
		return board_prev_select;
	}
	public void setBoard_prev_select(String board_prev_select) {
		this.board_prev_select = board_prev_select;
		prevTags=board_prev_select.split("/");
	}
	public String getBoard_next_select() {
		return board_next_select;
	}
	public void setBoard_next_select(String board_next_select) {
		this.board_next_select = board_next_select;
		nextTags=board_next_select.split("/");
	}
	public int getBoard_prev_seq() {
		return board_prev_seq;
	}
	public void setBoard_prev_seq(int board_prev_seq) {
		this.board_prev_seq = board_prev_seq;
	}
	public int getBoard_next_seq() {
		return board_next_seq;
	}
	public void setBoard_next_seq(int board_next_seq) {
		this.board_next_seq = board_next_seq;
	}
	public int getMc_state() {
		return mc_state;
	}
	public void setMc_state(int mc_state) {
		this.mc_state = mc_state;
	}
	public int getMc_max() {
		return mc_max;
	}
	public void setMc_max(int mc_max) {
		this.mc_max = mc_max;
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
	public int getPartCnt() {
		return partCnt;
	}
	public void setPartCnt(int partCnt) {
		this.partCnt = partCnt;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(String m_seq) {
		this.m_seq = Integer.parseInt(m_seq);
	}
	public int getM_rank() {
		return m_rank;
	}
	public int getMc_seq() {
		return mc_seq;
	}
	public void setMc_seq(int mc_seq) {
		this.mc_seq = mc_seq;
	}
	public int getMatchingCount() {
		return matchingCount;
	}
	public void setMatchingCount(int matchingCount) {
		this.matchingCount = matchingCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public void setM_rank(int m_rank) {
		this.m_rank = m_rank;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String[] getPrevTags() {
		return prevTags;
	}
	public void setPrevTags(String[] prevTags) {
		this.prevTags = prevTags;
	}
	public String[] getNextTags() {
		return nextTags;
	}
	public void setNextTags(String[] nextTags) {
		this.nextTags = nextTags;
	}
}
