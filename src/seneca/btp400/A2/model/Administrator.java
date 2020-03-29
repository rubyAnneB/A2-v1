package seneca.btp400.A2.model;

public class Administrator {
	private int adminid;
	private String fname;
	private String lname;
	private String email;
	private String password;

	public Administrator() {
		this(0, "", "", "");
	}

	public Administrator(int id, String fname, String lname, String email) {
		setID(id);
		setFname(fname);
		setLname(lname);
		setEmail(email);
	}

	public void setID(int id) {
		this.adminid = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return adminid;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fname + " " + lname;
	}
	
	public boolean isValid() {
		return adminid != 0;
	}
}
