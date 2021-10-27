package com.finalproject.itda.vo;

public class BoardVO {
	private int m_seq; //�쉶�썝踰덊샇 
	private int board_seq; //寃뚯떆臾쇰쾲�샇
	private int board_code;//移댄뀒怨좊━ 踰덊샇
	private String board_subject; //�젣紐�
	private String board_writedate; //�벑濡앹씪
	private int board_hit; //議고쉶�닔
	private int b_goodhit;//醫뗭븘�슂
	private int board_call; //�떊怨�
	private int board_black; //釉붾윮泥섎━
	private String m_userid; //�븘�씠�뵒
	private String m_nickname;//�땳�꽕�엫
	private int commentcount; //�뙎湲��닔 
	private int br_id; //�뙎湲�踰덊샇
	private String b_content;
	private String board_blockcontent;
	private String board_content;
	private String m_name; // �벑湲됱씠由� 
	
	private int board_prev_seq;
	private int board_next_seq;
	private String board_prev_subject;
	private String board_next_subject;
	private String board_prev_select;
	private String board_next_select;
	
	private String prevTags[];
	private String nextTags[];
	private String[] tag;
	private int board_block;
	private int replyCount;
	private String i_url;
	private String thumbImg;
	
	//�뙎湲� �닔 
	private int br_count;
	//--�땳�꽕�엫 愿�由�--
	//--�땳�꽕�엫 愿�由�--
	//--移댄뀒怨좊━ 愿�由�--
	//--移댄뀒怨좊━ 愿�由�--

	//--�옣�꽣 愿�由�--
	private String board_shopcontent;
	//--�옣�꽣 愿�由�--
	//--�깭洹� 愿�由�--
	private String board_select;
	//--태그 관리--
	//--이미지 관리--
	private int imageseq;	//이미지 관련
	private String l_Url;	//이미지 관련
	
	private String Searchkeyword; //검색 관련 
	private String Keywordselect; //검색어
	
	
	
	
	
	public String getSearchkeyword() {
		return Searchkeyword;
	}
	public void setSearchkeyword(String searchkeyword) {
		Searchkeyword = searchkeyword;
	}
	public String getKeywordselect() {
		return Keywordselect;
	}
	public void setKeywordselect(String keywordselect) {
		Keywordselect = keywordselect;
	}
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
	
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
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
		tag = board_select.split("/");
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
	public String[] getTag() {
		return tag;
	}
	public void setTag(String[] tag) {
		this.tag = tag;
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
	public String getI_url() {
		return i_url;
	}
	public void setI_url(String i_url) {
		this.i_url = i_url;
	}
	public String getThumbImg() {
		return thumbImg;
	}
	public void setThumbImg(String thumbImg) {
		this.thumbImg = thumbImg;
	}
}

