package com.fluxkart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fluxkart.dto.FluxkartDto;
import com.fluxkart.entity.ContactResponse;
import com.fluxkart.service.FluxkartService;

@RestController
public class FluxkartController {

	@Autowired
	private FluxkartService fluxkartService;

	@PostMapping("/identify")
	public Map<String, ContactResponse> identify(@RequestBody FluxkartDto dto) {
		return fluxkartService.identify(dto);
	}

}
