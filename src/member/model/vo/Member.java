package member.model.vo;

import java.sql.Date;

public class Member {
//	T_NO	NUMBER	No		1	
//	T_ID	VARCHAR2(30 BYTE)	No		2	
//	T_PWD	VARCHAR2(100 BYTE)	No		3	
//	T_NAME	VARCHAR2(15 BYTE)	No		4	
//	PHONE	VARCHAR2(13 BYTE)	Yes		5	
//	EMAIL	VARCHAR2(100 BYTE)	Yes		6	
//	INTEREST	VARCHAR2(100 BYTE)	Yes		7	
//	EN_DATE	DATE	Yes	SYSDATE	8	
//	MO_DATE	DATE	Yes	SYSDATE	9	
//	ST	VARCHAR2(1 BYTE)	Yes	"'Y'
//	"	10	
	private int tNo;
	private String tId;
	private String tPwd;
	private String tName;
	private String phone;
	private String email;
	private String interest;
	private Date enDate;
	private Date moDate;
	private String st;
	
	public Member() {}
	
	public Member(int tNo, String tId, String tPwd, String tName, String phone, String email, String interest,
			Date enDate, Date moDate, String st) {
		super();
		this.tNo = tNo;
		this.tId = tId;
		this.tPwd = tPwd;
		this.tName = tName;
		this.phone = phone;
		this.email = email;
		this.interest = interest;
		this.enDate = enDate;
		this.moDate = moDate;
		this.st = st;
	}

	public Member(String tId, String tPwd, String tName, String phone, String email, String interest) {
		super();
		this.tId = tId;
		this.tPwd = tPwd;
		this.tName = tName;
		this.phone = phone;
		this.email = email;
		this.interest = interest;
	}

	public Member(String tId, String tName, String phone, String email, String interest) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.phone = phone;
		this.email = email;
		this.interest = interest;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String gettPwd() {
		return tPwd;
	}

	public void settPwd(String tPwd) {
		this.tPwd = tPwd;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public Date getEnDate() {
		return enDate;
	}

	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}

	public Date getMoDate() {
		return moDate;
	}

	public void setMoDate(Date moDate) {
		this.moDate = moDate;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return "Member [tNo=" + tNo + ", tId=" + tId + ", tPwd=" + tPwd + ", tName=" + tName + ", phone=" + phone
				+ ", email=" + email + ", interest=" + interest + ", enDate=" + enDate + ", moDate=" + moDate + ", st="
				+ st + "]";
	}
	
}
