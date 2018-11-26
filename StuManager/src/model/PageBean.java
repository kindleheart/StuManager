package model;

import java.util.List;

/**
 * 这是一个用于封装了分页的数据
 * 
 * @author Administrator 里面包含： 该页的课程集合数据 总的记录数 总页数 当前页 每页的记录数
 * @param <T>
 */
public class PageBean<T> {
	private int CurrentPage;// 当前页
	private int totalPage;// 总页数
	private int pageSize;// 每页的记录数
	private int totalSize;// 总的记录数
	private List<T> list;// 当前课程集合

	public PageBean(int currentPage, int totalPage, int pageSize, int totalSize, List<T> list) {
		super();
		CurrentPage = currentPage;
		this.totalPage = totalPage;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.list = list;
	}

	public PageBean() {
		super();
	}

	public int getCurrentPage() {
		return CurrentPage;
	}

	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
