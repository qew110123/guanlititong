package yineng.datacenter.manager.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class PageModel extends RowBounds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1345513765450343826L;
	
	private int pageRows = 10;
	private int currentPage = 1;
	private int totalRows = 0;
	private List<?> result;

	public PageModel() {
	}

	public PageModel(int pageRows, int currentPage) {
		this.pageRows = pageRows;
		this.currentPage = currentPage;
	}

	public PageModel(List<?> result, int pageRows, int currentPage, int totalRows) {
		this.result = result;
		this.pageRows = pageRows;
		this.currentPage = currentPage;
		this.totalRows = totalRows;
	}

	public int getOffset(int currentPage, int pageRows) {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		if (pageRows <= 0) {
			pageRows = this.pageRows;
		}
		return (currentPage - 1) * pageRows;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<?> result) {
		this.result = result;
	}

	public int getPageRows() {
		return pageRows;
	}

	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	public int getCurrentPage() {
		int totalPage = getTotalPage();
		if (this.currentPage > totalPage) {
			this.setCurrentPage(totalPage);
		} else if (this.currentPage < 1) {
			this.setCurrentPage(1);
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPage() {
		int totalPage = 0;
		if (this.getTotalRows() > 0) {
			if (this.getTotalRows() % this.getPageRows() == 0) {
				totalPage = this.getTotalRows() / this.getPageRows();
			} else {
				totalPage = this.getTotalRows() / this.getPageRows() + 1;
			}
		}
		return totalPage;
	}

}
