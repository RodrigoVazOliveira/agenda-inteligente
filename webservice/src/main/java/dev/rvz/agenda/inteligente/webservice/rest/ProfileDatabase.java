package dev.rvz.agenda.inteligente.webservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateProfileRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.ProfileResponseDTO;

@FeignClient(url = "${url.base.profiles}", name = "ProfileDatabase", value = "ProfileDatabase")
public interface ProfileDatabase {

	@PostMapping
	ProfileResponseDTO create(@RequestBody CreateProfileRequestDTO createProfileRequestDTO);

	@GetMapping
	Iterable<ProfileResponseDTO> getAll();

	@GetMapping("/{id}")
	ProfileResponseDTO getById(@PathVariable Long id);
}