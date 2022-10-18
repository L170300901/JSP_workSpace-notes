package kr.co.seoulit.model;

public class Member {
	public String id;
	public String pw;
	public String addr;
	public String tel;

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getAddr() {
		return addr;
	}

	public String getTel() {
		return tel;
	}
}
