package com.qa.PersonProjectSky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person does not exist with specified ID.")
public class PersonNotFoundException extends EntityNotFoundException {
}
