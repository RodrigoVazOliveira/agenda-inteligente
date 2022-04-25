package dev.rvz.agenda.inteligente.webservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.rvz.agenda.inteligente.webservice.dtos.CreateDiaryRequestDTO;
import dev.rvz.agenda.inteligente.webservice.dtos.DiaryResponseDTO;

@FeignClient(url = "${url.base.diaries}", name = "DiaryDatabase", value = "DiaryDatabase")
public interface DiaryDatabase {

	@PostMapping
	DiaryResponseDTO create(@RequestBody CreateDiaryRequestDTO createDiaryRequestDTO);

	@GetMapping("/{id}")
	DiaryResponseDTO getById(@PathVariable Long id);

	@GetMapping
	Iterable<DiaryResponseDTO> getAll();

	@GetMapping("/profile/{email}")
	Iterable<DiaryResponseDTO> getDiaryByEmailProfile(@PathVariable String email);

}
