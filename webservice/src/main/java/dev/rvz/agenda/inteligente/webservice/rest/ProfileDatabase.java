package dev.rvz.agenda.inteligente.webservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;

@FeignClient(url = "${url.profiles}", name = "ProfileDatabase", value = "ProfileDatabase")
public interface ProfileDatabase {

	@PostMapping
	ProfileResponseDTO create(@RequestBody CreateProfileRequestDTO createProfileRequestDTO);
}
