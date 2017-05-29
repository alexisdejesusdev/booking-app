package com.luxoft.booking.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.luxoft.booking.model.exception.ControlledException;
import com.luxoft.booking.model.util.Message;

/**
 * Utility controller to manage globally thrown exceptions in a centralized way.
 * 
 * @author Alexis De Jesús
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {
	private final Log logger = LogFactory.getLog(getClass());

	/**
	 * Manages all ControlledException and wraps them into a standardized model
	 * for the front-end to process.
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(ControlledException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Message handleGlobalEdgeException(HttpServletRequest request, ControlledException e) {
		// Get the message of the returned exception to the front end
		Message message = new Message(e.getMessage());

		if (this.logger.isErrorEnabled()) {
			this.logger.error("A ControlledException was caught [" + e + "]. ");
		}

		return message;

	}

	/**
	 * Manages all Exception and wraps them into a standardized model for the
	 * front-end to process.
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	public Message handleException(HttpServletRequest request, Exception e) {
		// Get the message of the returned exception to the front end
		Message message = new Message(e.getMessage());

		if (this.logger.isErrorEnabled()) {
			this.logger.error("An unexpected Exception was caught [" + e + "]. ");
		}

		return message;

	}

	/**
	 * Manages all RuntimeException and wraps them into a standardized model for
	 * the front-end to process.
	 * 
	 * @param request
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ RuntimeException.class })
	public Message handleRuntimeException(HttpServletRequest request, Exception e) {
		// Get the message of the returned exception to the front end
		Message message = new Message(e.getMessage());

		if (this.logger.isErrorEnabled()) {
			this.logger.error("An unexpected RuntimeException was caught [" + e + "]. ");
		}

		return message;

	}
}
