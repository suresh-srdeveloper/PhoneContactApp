package com.sureshit.service;

import java.util.List;

import com.sureshit.bindings.ContactBinding;

public interface ContactService {

	public String saveContact(ContactBinding contactBinding);
	public List<ContactBinding> getAllContacts();
	public ContactBinding editContact(Long contactId);
	public List<ContactBinding> deleteContact(Long contactId);

}
