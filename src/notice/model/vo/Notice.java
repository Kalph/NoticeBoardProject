package notice.model.vo;

import java.sql.Date;

public class Notice {
	private int nNo;
	private String nCid;
	private String nTitle;
	private String nContent;
	private String nWriter;
	private int viewCt;
	private Date nDate;
	private String st;
	
	public Notice() {}

	public Notice(int nNo, String nCid, String nTitle, String nContent, String nWriter, int viewCt, Date nDate,
			String st) {
		super();
		this.nNo = nNo;
		this.nCid = nCid;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWriter = nWriter;
		this.viewCt = viewCt;
		this.nDate = nDate;
		this.st = st;
	}

	public Notice(String nCid, String nTitle, String nContent, String nWriter) {
		super();
		this.nCid = nCid;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWriter = nWriter;
	}
	

	public Notice(int nNo, String nCid, String nTitle, String nContent) {
		super();
		this.nNo = nNo;
		this.nCid = nCid;
		this.nTitle = nTitle;
		this.nContent = nContent;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnCid() {
		return nCid;
	}

	public void setnCid(String nCid) {
		this.nCid = nCid;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public int getViewCt() {
		return viewCt;
	}

	public void setViewCt(int viewCt) {
		this.viewCt = viewCt;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "Notice [nNo=" + nNo + ", nCid=" + nCid + ", nTitle=" + nTitle + ", nContent=" + nContent + ", nWriter="
				+ nWriter + ", viewCt=" + viewCt + ", nDate=" + nDate + ", st=" + st + "]";
	}
	
}
