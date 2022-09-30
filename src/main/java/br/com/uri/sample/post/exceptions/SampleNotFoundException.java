package br.com.uri.sample.post.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SampleNotFoundException extends RuntimeException {

    public SampleNotFoundException(String message) {
        super(message);
    }

}
