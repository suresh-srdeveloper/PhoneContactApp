package com.sureshit.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sureshit.bindings.ContactBinding;
import com.sureshit.entities.ContactDao;
import com.sureshit.repo.ContactRepository;
import com.sureshit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public String saveContact(ContactBinding contactBinding) {

		ContactDao contactDao = new ContactDao();
		BeanUtils.copyProperties(contactBinding, contactDao);
		contactDao = contactRepository.save(contactDao);
		if (contactDao.getContactID() != null) {
			return "SUCCESS";
		}
		return "FAILURE";

	}

	@Override
	public List<ContactBinding> getAllContacts() {

		List<ContactDao> contactDaoList = contactRepository.findAll();
		List<ContactBinding> contactBindingList = new ArrayList<ContactBinding>();
		for (ContactDao contactDao : contactDaoList) {

			ContactBinding contactBinding = new ContactBinding();
			BeanUtils.copyProperties(contactDao, contactBinding);
			contactBindingList.add(contactBinding);
		}
		return contactBindingList;
	}

	@Override
	public ContactBinding editContact(Long contactId) {
		Optional<ContactDao> findById = contactRepository.findById(contactId);
		if (findById.isPresent()) {
			ContactDao contactDao = findById.get();
			ContactBinding contactBinding = new ContactBinding();
			BeanUtils.copyProperties(contactDao, contactBinding);
			return contactBinding;
		}
		return null;
	}

	@Override
	public List<ContactBinding> deleteContact(Long contactId) {
		contactRepository.deleteById(contactId);
		List<ContactBinding> dataList = new ArrayList<>();
		List<ContactDao> findAll = contactRepository.findAll();
		for (ContactDao contactDao : findAll) {

			ContactBinding contactBinding = new ContactBinding();
			BeanUtils.copyProperties(contactDao, contactBinding);
			dataList.add(contactBinding);

		}

		return dataList;
	}

}
