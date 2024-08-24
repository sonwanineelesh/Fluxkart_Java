package com.fluxkart.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fluxkart.dto.FluxkartDto;
import com.fluxkart.entity.ContactResponse;

@Service
public interface FluxkartService {

	public Map<String, ContactResponse> identify(FluxkartDto dto);

}
