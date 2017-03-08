package com.joyworks.entity;

import java.util.List;

/**
 * 分页查询
 * @param <T>
 */
public class Page<T> {
	private Integer pageSize;// 每页显示的条数
	private Integer pageNo; // 当前页页码
	private Integer totalRecoards;// 总记录数
	private Integer pageTotal;// 总页数
	private List<T> pages;

	public Page() {
		super();
	}

	public Page(String pageNo, Integer totalRecoards, Integer pageSize) {
		int defaultPageNo = 1;
		try {
			defaultPageNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
		}
		this.pageNo = defaultPageNo;
		this.totalRecoards = totalRecoards;
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNo=" + pageNo + ", totalRecoards=" + totalRecoards + ", pageTotal="
				+ pageTotal + ", pages=" + pages + "]";
	}

	public List<T> getPages() {
		return pages;
	}

	public void setPages(List<T> pages) {
		this.pages = pages;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		if (pageNo > getPageTotal()) {
			pageNo = getPageTotal();
		}
		if (pageNo < 1) {
			pageNo = 1;
		}
		return pageNo;
	}

	public Integer getTotalRecoards() {
		return totalRecoards;
	}

	public Integer getPageTotal() {
		return totalRecoards / pageSize + (totalRecoards % pageSize == 0 ? 0 : 1);
	}

}
