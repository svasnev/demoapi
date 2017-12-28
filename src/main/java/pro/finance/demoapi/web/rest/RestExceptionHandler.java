package pro.finance.demoapi.web.rest;



import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Value not found")
	@ExceptionHandler(EntityNotFoundException.class)
	public void handleEntityNotFoundException(Exception ex){
		logger.info(ex.getMessage());
	}

	@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Value not found")
	@ExceptionHandler(IllegalArgumentException.class)
	public void handleIllegalArgumentException(Exception ex){
		logger.info(ex.getMessage());
	}

}
