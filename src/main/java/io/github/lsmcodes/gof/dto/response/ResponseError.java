package io.github.lsmcodes.gof.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseError {

        private LocalDateTime timestamp;
        private int status;
        private String message;

}