package com.suchiit.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suchiit.constants.CollectionConstants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection=CollectionConstants.DATARECORD)
public class DataRecord {

	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String contactNumber;
    @Indexed(unique=true)
	@NotNull
	private String email;
    private String password; 
    private Address address;
	private String higherEductaion;
	private String workExperience;
	private String technology;
	private String preferredModeOfWork;
	private String expectedsalary;
	private String workAuthorization;
	private String jobSearchlocationpreference;
	private String roles;
	@CreatedDate
	private Date createdAt;
	@LastModifiedDate
	private Date lastmodifiedDate;
	@JsonIgnore
	private Date dueDate;
	private String status;
	private String comments;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getHigherEductaion() {
		return higherEductaion;
	}
	public void setHigherEductaion(String higherEductaion) {
		this.higherEductaion = higherEductaion;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getPreferredModeOfWork() {
		return preferredModeOfWork;
	}
	public void setPreferredModeOfWork(String preferredModeOfWork) {
		this.preferredModeOfWork = preferredModeOfWork;
	}
	public String getExpectedsalary() {
		return expectedsalary;
	}
	public void setExpectedsalary(String expectedsalary) {
		this.expectedsalary = expectedsalary;
	}
	public String getWorkAuthorization() {
		return workAuthorization;
	}
	public void setWorkAuthorization(String workAuthorization) {
		this.workAuthorization = workAuthorization;
	}
	public String getJobSearchlocationpreference() {
		return jobSearchlocationpreference;
	}
	public void setJobSearchlocationpreference(String jobSearchlocationpreference) {
		this.jobSearchlocationpreference = jobSearchlocationpreference;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastmodifiedDate() {
		return lastmodifiedDate;
	}
	public void setLastmodifiedDate(Date lastmodifiedDate) {
		this.lastmodifiedDate = lastmodifiedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public DataRecord(String id, String firstName, String middleName, String lastName, Date dateOfBirth,
			String contactNumber, @NotNull String email, String password, Address address, String higherEductaion,
			String workExperience, String technology, String preferredModeOfWork, String expectedsalary,
			String workAuthorization, String jobSearchlocationpreference, String roles, Date createdAt,
			Date lastmodifiedDate, Date dueDate, String status, String comments) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.higherEductaion = higherEductaion;
		this.workExperience = workExperience;
		this.technology = technology;
		this.preferredModeOfWork = preferredModeOfWork;
		this.expectedsalary = expectedsalary;
		this.workAuthorization = workAuthorization;
		this.jobSearchlocationpreference = jobSearchlocationpreference;
		this.roles = roles;
		this.createdAt = createdAt;
		this.lastmodifiedDate = lastmodifiedDate;
		this.dueDate = dueDate;
		this.status = status;
		this.comments = comments;
	}
	public DataRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
