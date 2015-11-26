package baseclass;

import java.io.Serializable;

public class Professor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877224401425966336L;
	private String name;
	private String email;
	private String office;
	private String officeHours;
	private String phoneNumber;
	
	public Professor(String name, String email, String office, String officeHours, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.office = office;
		this.officeHours = officeHours;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
