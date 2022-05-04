package dev.rvz.agenda.inteligente.webservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.rvz.agenda.inteligente.webservice.rest.TestTimeOutFeign;

@RestController
@RequestMapping(path = "/test-timeout")
class TestCircuitBreakerTimeOutController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TestCircuitBreakerTimeOutController.class);
	private final TestTimeOutFeign timeOutFeign;

	public TestCircuitBreakerTimeOutController(TestTimeOutFeign timeOutFeign) {
		this.timeOutFeign = timeOutFeign;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	String getTest() {
		LOGGER.info("getTest");
		return this.timeOutFeign.testTimeOut();
	}
}
