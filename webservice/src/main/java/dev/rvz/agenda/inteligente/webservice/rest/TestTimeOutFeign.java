package dev.rvz.agenda.inteligente.webservice.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "TestTimeOutFeign", url = "http://localhost:8080/database")
public interface TestTimeOutFeign {
	final static Logger LOGGER = LoggerFactory.getLogger(TestTimeOutFeign.class);

	@PostMapping(value = "/test-timeout")
	@CircuitBreaker(name = "webservice_timeout", fallbackMethod = "testTimeOutException")
	String testTimeOut();

	default String testTimeOutException(RuntimeException e) {
		LOGGER.info("testTimeOutException - message : {}", e.getMessage());
		return "SERVIDOR DO BANCO DE DADOS INDISPONIVEL";
	}

}