package com.fluxkart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluxkart.dto.FluxkartDto;
import com.fluxkart.entity.ContactResponse;
import com.fluxkart.entity.Fluxkart;
import com.fluxkart.repository.ContactRepository;
import com.fluxkart.repository.FluxkartRepository;

@Service
public class FluxkartServiceImpl implements FluxkartService {

	@Autowired
	private FluxkartRepository fluxkartRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Map<String, ContactResponse> identify(FluxkartDto dto) {
		var contactByPhoneNumber = fluxkartRepository.findByPhoneNumber(dto.getPhoneNumber());
		var contactByEmail = fluxkartRepository.findByEmail(dto.getEmail());
		var idByEmail = 0;
		List<String> emails = new ArrayList<>();
		List<String> phoneNumbers = new ArrayList<>();
		List<Integer> secondaryContactIds = new ArrayList<>();
		String linkPre1 = "";
		String numByEmail = null;
		String em = null;

		for (Fluxkart responseEmail : contactByEmail) {
			if (responseEmail != null) {
				linkPre1 = responseEmail.getLinkPrecedence();
				idByEmail = responseEmail.getId();// 11
				em = responseEmail.getEmail();
				numByEmail = responseEmail.getPhoneNumber();// 919191
			}
		}
		for (Fluxkart response : contactByPhoneNumber) {
			if (linkPre1.equals("Primary")) {
				response.setLinkedId(idByEmail);
				response.setLinkPrecedence("Secondary");
				emails.add(em);// goerge
				phoneNumbers.add(numByEmail);// 919191
			}}
		
		if (contactByPhoneNumber.size() != 0) 
			return searching(contactByPhoneNumber, contactByEmail, emails, phoneNumbers, secondaryContactIds);
			
		if (!contactByEmail.isEmpty()) {
			for (Fluxkart response : contactByEmail) {
				var phoneByEmail = fluxkartRepository.findByPhoneNumber(response.getPhoneNumber());

				return searching(phoneByEmail, contactByEmail, emails, phoneNumbers, secondaryContactIds);
			}
		}
		return null;
	}

	public Map<String, ContactResponse> searching(List<Fluxkart> byPhoneNumber, List<Fluxkart> byEmail,
			List<String> emails, List<String> phoneNumbers, List<Integer> secondaryContactIds) {
		ContactResponse contactResponse = new ContactResponse();
		Map<String, ContactResponse> result = new HashMap<>();
		for (Fluxkart response : byPhoneNumber) {
			emails.add(response.getEmail());// biff
			phoneNumbers.add(response.getPhoneNumber());
			if (response.getLinkPrecedence().equals("Secondary")) {
				secondaryContactIds.add(response.getId());// 27
				contactResponse.setPrimaryContactId(response.getLinkedId());
			} else {
				contactResponse.setPrimaryContactId(response.getId());
			}
		}
		emails = emails.stream().distinct().collect(Collectors.toList());
		phoneNumbers = phoneNumbers.stream().distinct().collect(Collectors.toList());
		contactResponse.setEmail(emails);
		contactResponse.setPhoneNumber(phoneNumbers);
		contactResponse.setSecondaryContactId(secondaryContactIds);
		contactRepository.save(contactResponse);

		result.put("contact", contactResponse);

		return result;
	}

}
