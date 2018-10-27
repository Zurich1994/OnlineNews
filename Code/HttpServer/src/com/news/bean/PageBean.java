package com.news.bean;
public class PageBean {
	private int pageSize=200;
	private int currentPage=1;
	private int pageCount=1;
	private int totalCount=0;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;

		this.pageCount = (this.totalCount-1)/this.pageSize+1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage>this.pageCount)
			this.currentPage=this.pageCount;
		else if(currentPage<1)
			this.currentPage=1;
		else
			this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount() {
		this.pageCount = (this.totalCount-1)/this.pageSize+1;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.pageCount = (this.totalCount-1)/this.pageSize+1;
	}
	
	
}
