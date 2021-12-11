package com.sureshit.bindings;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContactBinding {

	private Long contactID;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private String activeSwitch;
	private LocalDate createdDate;
	private LocalDate updatedDate;

}
