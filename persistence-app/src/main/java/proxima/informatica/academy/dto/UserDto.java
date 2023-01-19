package proxima.informatica.academy.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class UserDto {
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private Date dateofbirth;
	private Timestamp regdate;
	private Integer role;
	private String imgpath;
	private String note;
	private Boolean enabled;
	
	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserDto(Integer id, String email, String password, String firstname, String lastname, Date dateofbirth,
			Timestamp regdate, Integer role, String imgpath, String note, Boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.regdate = regdate;
		this.role = role;
		this.imgpath = imgpath;
		this.note = note;
		this.enabled = enabled;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Date getDateofbirth() {
		return dateofbirth;
	}



	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}



	public Timestamp getRegdate() {
		return regdate;
	}



	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}



	public Integer getRole() {
		return role;
	}



	public void setRole(Integer role) {
		this.role = role;
	}



	public String getImgpath() {
		return imgpath;
	}



	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", dateofbirth=" + dateofbirth + ", regdate=" + regdate + ", role=" + role
				+ ", imgpath=" + imgpath + ", note=" + note + ", enabled=" + enabled + "]";
	}
	
	

}
