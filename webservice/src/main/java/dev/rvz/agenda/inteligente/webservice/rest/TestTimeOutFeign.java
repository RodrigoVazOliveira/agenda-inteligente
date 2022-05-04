package dev.rvz.agenda.inteligente.webservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "TestTimeOutFeign", url = "http://localhost:8080/database")
public interface TestTimeOutFeign {

	@PostMapping(value = "/test-timeout")
	String testTimeOut();

}