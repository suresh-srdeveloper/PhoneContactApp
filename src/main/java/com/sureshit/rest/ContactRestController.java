package com.sureshit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sureshit.bindings.ContactBinding;
import com.sureshit.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description="Operation pertaining to Contact details in Phone Book Application.")
public class ContactRestController {

	@Autowired
	private ContactService contactService;
	private ResponseEntity<Object> response = null;

	@PostMapping("/savecontact")
	@ApiOperation(
			value = "This operation is used to create contact details.", 
			response = ResponseEntity.class
	)
	public ResponseEntity<Object> saveContact(@RequestBody ContactBinding contactBinding) {
		String status = contactService.saveContact(contactBinding);
		response = new ResponseEntity<Object>(status, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/contacts")
	@ApiOperation(
			value = "This operation is used to view all contact details.", 
			response = ResponseEntity.class
	)
	public ResponseEntity<Object> viewAllContacts() {
		List<ContactBinding> dataList = contactService.getAllContacts();
		response = new ResponseEntity<Object>(dataList, HttpStatus.OK);
		return response;
	}

	@GetMapping("/editcontact/{contactId}")
	@ApiOperation(
			value = "This operation is used to get a contact for edit purpose.", 
			response = ResponseEntity.class
	)
	public ResponseEntity<Object> editContact(@PathVariable Long contactId) {
		ContactBinding contactBinding = contactService.editContact(contactId);
		response = new ResponseEntity<Object>(contactBinding, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/deletecontact/{contactId}")
	@ApiOperation(
			value = "This operation is used to delete a contact.", 
			response = ResponseEntity.class
	)
	public ResponseEntity<Object> deleteContact(@PathVariable Long contactId) {
		List<ContactBinding> list = contactService.deleteContact(contactId);
		response = new ResponseEntity<Object>(list, HttpStatus.OK);
		return response;
	}

}
