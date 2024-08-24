package com.fluxkart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fluxkart.entity.Fluxkart;
@Repository
public interface FluxkartRepository extends CrudRepository<Fluxkart, Integer>{

	List<Fluxkart> findByEmail(String email);

	List<Fluxkart> findByPhoneNumber(String phoneNumber);

	
}

