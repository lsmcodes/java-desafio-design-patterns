package io.github.lsmcodes.gof.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

        private T data;
        private Object errors;

        public void addErrorsToResponse(int status, String message) {
                ResponseError responseError = new ResponseError()
                                .setTimestamp(LocalDateTime.now())
                                .setStatus(status)
                                .setMessage(message);
                setErrors(responseError);
        }

}