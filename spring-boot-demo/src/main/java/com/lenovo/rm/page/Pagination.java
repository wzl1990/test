package com.lenovo.rm.page;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
 
public class Pagination<T> implements Serializable {
     
	private static final long serialVersionUID = 1332138383840840409L;

	/**
     * 每页显示条数
     */
    private int pageSize=10;
     
    /**
     * 总页数
     */
    private int pageCount=1;
    
    /**
     * 当前页
     */
    private int currentPage=1;
     
    /**
     * 原集合
     */
    private List<T> data;
    
    /**
     * 总记录条数
     */
    private long totalCount=1;
    
    
    public Pagination() {
    }
    
    public Pagination(Integer currentPage,Integer pageSize) {
		super();
		this.pageSize = (pageSize <= 0) ? this.pageSize : pageSize;
		this.currentPage = (currentPage <= 0) ? 1 : currentPage;
	}
    
    public Pagination(List<T> data, int pageSize,int currentPage) {
        this.data = data;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.pageCount = data.size()/pageSize;
		if(data!=null && data.size()!=0){
			this.totalCount=data.size();
	        if(data.size()%pageSize!=0){
	            this.pageCount++;
	        }
	        int fromIndex = (currentPage - 1) * pageSize;
	        if (fromIndex >= data.size()) {
	        	this.data=Collections.emptyList();
	        }else{
	        	  int toIndex = currentPage * pageSize;
	              if (toIndex >= data.size()) {
	                  toIndex = data.size();
	              }
	              this.data=data.subList(fromIndex, toIndex);
	        }
		}
    }
    
    public int getPageSize() {
        return pageSize;
    }
 
    public List<T> getData() {
        return data;
    }
 
    public int getPageCount() {
        return pageCount;
    }
    
    public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	

}