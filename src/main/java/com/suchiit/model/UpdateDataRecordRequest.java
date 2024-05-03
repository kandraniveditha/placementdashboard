package com.suchiit.model;

import java.util.Date;

import org.springframework.data.annotation.LastModifiedDate;



public class UpdateDataRecordRequest {

	private String candidateId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String contactNumber;
	private String email;
	private Address address;
	private String higherEductaion;
	private String workExperience;
	private String technology;
	private String preferredModeOfWork;
	private String expectedsalary;
	private String workAuthorization;
	private String jobSearchlocationpreference;
	@LastModifiedDate
	private Date lastmodifiedDate;
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
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
	public Date getLastmodifiedDate() {
		return lastmodifiedDate;
	}
	public void setLastmodifiedDate(Date lastmodifiedDate) {
		this.lastmodifiedDate = lastmodifiedDate;
	}
	public UpdateDataRecordRequest(String candidateId, String firstName, String middleName, String lastName,
			Date dateOfBirth, String contactNumber, String email, Address address, String higherEductaion,
			String workExperience, String technology, String preferredModeOfWork, String expectedsalary,
			String workAuthorization, String jobSearchlocationpreference, Date lastmodifiedDate) {
		super();
		this.candidateId = candidateId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.higherEductaion = higherEductaion;
		this.workExperience = workExperience;
		this.technology = technology;
		this.preferredModeOfWork = preferredModeOfWork;
		this.expectedsalary = expectedsalary;
		this.workAuthorization = workAuthorization;
		this.jobSearchlocationpreference = jobSearchlocationpreference;
		this.lastmodifiedDate = lastmodifiedDate;
	}
	public UpdateDataRecordRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
