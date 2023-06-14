package in.suresh.entity;

public class Student {

	private Integer sid;
	private String sname;
	private String gender;
	private Integer marks;
	
	

	public Student() {
		super();
	}

	public Student(Integer sid, String sname, String gender, Integer marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.marks = marks;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", marks=" + marks + "]";
	}
	

}
