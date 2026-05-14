package com.ironhack.jpalab.repository;

import com.ironhack.jpalab.contact.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}