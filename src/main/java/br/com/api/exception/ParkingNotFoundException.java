package br.com.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends EmptyResultDataAccessException {
	
	private static final long serialVersionUID = 1L;

    public ParkingNotFoundException(String id) {
        super("Parking not found with Id: " + id, 1);
    }

}
