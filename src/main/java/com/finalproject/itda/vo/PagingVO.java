package com.finalproject.itda.vo;

public class PagingVO {
	
	   private int totalRecord;//총레코드수 
	   private int nowPage=1;// 현재페이지 현재 페이지 정보를 넣어주면 무조건 1page
	   private int totalPage; //총페이지수
	   private int onePageRecord=17;//한페이지당 레코드수 (나중에 얘를 10으로 바꿔주면 한페이지에 10개가 찍힌다)
	   
	  
	   //검색어 관련된거 많이 필요함 
		/*
		 * private String searchKey; private String searchWord;
		 */
	   private String searchKeyword; //검색어 관련 키워드 
	   
	   
	   //페이지
	   private int onePageNumCount=100; // 한페이지당 출력할 페이지 수
	   private int startPage=1; //스타트 페이지
	   private int lastPage=6;
	   
	   public int getTotalRecord() {
	      return totalRecord;
	   }
	   public void setTotalRecord(int totalRecord) {
	      //(총레코드수가 구해지면 총 페이지수를 구하게 하겠다)
	      this.totalRecord = totalRecord;
	      
	      //총페이지수 계산할때는 둘중에 하나 실수로 만들어서 계산해야한다 . //반올림
	      totalPage=(int)Math.ceil(totalRecord/(double)onePageRecord);
	      
	      if(nowPage==totalPage) {
	    	  lastPage=totalRecord%onePageRecord;
	      }
	   }
	   

	   
	   
	   public int getNowPage() {
		   System.out.println("nowPage = " + nowPage);
	      return nowPage;
	   }
	   public void setNowPage(int nowPage) {
	      this.nowPage = nowPage;
	      
	      //페이지 번호가 들어오면
	      if(nowPage!=0) { //페이지 번호가 있을 때 
	    	  //		   현재페이지		한페이지당 출력할 페이지 수 
	    	  startPage = (nowPage-1) / onePageNumCount * onePageNumCount+1;
	      }
	   }
	   public int getTotalPage() {
	      return totalPage;
	   }
	   public void setTotalPage(int totalPage) {
	      this.totalPage = totalPage;
	   }
	   public int getOnePageRecord() {
		   System.out.println("onePageRecord = " + onePageRecord);
	      return onePageRecord;
	   }
	   public void setOnePageRecord(int onePageRecord) {
	      onePageRecord = onePageRecord;
	   }
	   
	   //검색어와 관련 
	


		public int getOnePageNumCount() {
			return onePageNumCount;
		}
		public String getSearchKeyword() {
			return searchKeyword;
		}
		public void setSearchKeyword(String searchKeyword) {
			this.searchKeyword = searchKeyword;
		}
		public int getLastPage() {
			System.out.println("lastPage = " + lastPage);
			return lastPage;
		}
		public void setLastPage(int lastPage) {
			this.lastPage = lastPage;
		}
		public void setOnePageNumCount(int onePageNumCount) {
			this.onePageNumCount = onePageNumCount;
		}
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
}
