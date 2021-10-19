package com.finalproject.itda.vo;

public class CalendarVO {
	private int board_seq;
	private String url;
	private String title;
	private String start;
	public void setBoard_seq(int board_seq) {
		url = "/itda/matchingView?board_seq=" + board_seq;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	
}
