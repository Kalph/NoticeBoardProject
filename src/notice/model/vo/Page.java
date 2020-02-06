package notice.model.vo;

public class Page {
	private int curPage;
	private int listCt;
	private int limitPage;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int limitNotice;
	
	public Page() {}

	public Page(int curPage, int listCt, int limitPage, int maxPage, int startPage, int endPage, int limitNotice) {
		super();
		this.curPage = curPage;
		this.listCt = listCt;
		this.limitPage = limitPage;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.limitNotice = limitNotice;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getListCt() {
		return listCt;
	}

	public void setListCt(int listCt) {
		this.listCt = listCt;
	}

	public int getLimitPage() {
		return limitPage;
	}

	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimitNotice() {
		return limitNotice;
	}

	public void setLimitNotice(int limitNotice) {
		this.limitNotice = limitNotice;
	}

	@Override
	public String toString() {
		return "Page [curPage=" + curPage + ", listCt=" + listCt + ", limitPage=" + limitPage + ", maxPage=" + maxPage
				+ ", startPage=" + startPage + ", endPage=" + endPage + ", limitNotice=" + limitNotice + "]";
	}
	
}
