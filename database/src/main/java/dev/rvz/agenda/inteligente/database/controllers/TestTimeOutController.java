package dev.rvz.agenda.inteligente.database.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test-timeout")
class TestTimeOutController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TestTimeOutController.class);

	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	String testTimeOut() throws InterruptedException {
		LOGGER.info("testTimeOut");
		Thread.sleep(20000);
		return "deu bom";
	}
}
