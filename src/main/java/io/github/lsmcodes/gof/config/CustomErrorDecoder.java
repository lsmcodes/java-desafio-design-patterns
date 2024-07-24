package io.github.lsmcodes.gof.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String methodKey, Response response) {
                switch (response.status()) {
                        case 400:
                                return new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
                        case 404:
                                return new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
                        default:
                                return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
                }
        }

}