package com.sureshit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Table(name = "CONTACT_DETAILS")
@Entity
@Data
public class ContactDao {

	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	private Long contactID;

	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;
	@Column(name = "ACTIVE_SW")
	private String activeSwitch;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private LocalDate updatedDate;

}
