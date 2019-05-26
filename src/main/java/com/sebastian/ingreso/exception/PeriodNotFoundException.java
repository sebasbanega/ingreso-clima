package com.sebastian.ingreso.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "period not found")
public class PeriodNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6000972572630743272L;

}
