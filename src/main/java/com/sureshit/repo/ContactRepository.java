package com.sureshit.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sureshit.entities.ContactDao;
@Repository
public interface ContactRepository extends JpaRepository<ContactDao, Serializable> {

}
