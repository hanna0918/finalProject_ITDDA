package com.finalproject.itda.vo;

public class MatchingVO {
	private int b_id;
	private String b_select;
	private String b_subject;
	private String b_content;
	private String m_userid;
	private String b_writedate;
	private String b_matchingdate;
	private String b_where;
	private String b_frequency;
	private int b_nowpart;
	private int b_maxpart;
	private int b_hit;
	private String tags[];
	
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_select() {
		return b_select;
	}
	public void setB_select(String b_select) {
		this.b_select = b_select;
		
		tags = b_select.split("/");
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
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
	public String getB_writedate() {
		return b_writedate;
	}
	public void setB_writedate(String b_writedate) {
		this.b_writedate = b_writedate;
	}
	public String getB_matchingdate() {
		return b_matchingdate;
	}
	public void setB_matchingdate(String b_matchingdate) {
		this.b_matchingdate = b_matchingdate;
	}
	public String getB_where() {
		return b_where;
	}
	public void setB_where(String b_where) {
		this.b_where = b_where;
	}
	public String getB_frequency() {
		return b_frequency;
	}
	public void setB_frequency(String b_frequency) {
		this.b_frequency = b_frequency;
	}
	public int getB_nowpart() {
		return b_nowpart;
	}
	public void setB_nowpart(int b_nowpart) {
		this.b_nowpart = b_nowpart;
	}
	public int getB_maxpart() {
		return b_maxpart;
	}
	public void setB_maxpart(int b_maxpart) {
		this.b_maxpart = b_maxpart;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
