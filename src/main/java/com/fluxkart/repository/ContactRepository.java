package com.fluxkart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fluxkart.entity.ContactResponse;
@Repository
public interface ContactRepository extends CrudRepository<ContactResponse, Integer>{

	

}
