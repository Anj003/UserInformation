package com.example.demo.model;

import java.time.LocalDate;
import java.time.temporal.Temporal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usertable")
public class UserModel {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private int userId;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = "Email is mandatory")
	@Column(name = "email_id")
	private String emailId;
	
	@Size(min = 10, max = 10, message = "Number should have 10 digits onlyy")
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column(name = "ph_no")
	private String phNo;
	
	@NotBlank(message = "Address is mandatory")
	@Column(name = "address")
	private String address;
	
	@Column(name = "date_of_reg")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private LocalDate dateOfReg;
	
	@NotBlank(message = "userPass is mandatory")
	@Column(name = "user_pass")
	private String userPass;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Temporal getDateOfReg() {
		return dateOfReg;
	}

	public void setDateOfReg(LocalDate dateOfReg) {
		this.dateOfReg = dateOfReg;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", name=" + name + ", emailId=" + emailId + ", phNo=" + phNo
				+ ", address=" + address + ", dateOfReg=" + dateOfReg + ", userPass=" + userPass + "]";
	}

}
