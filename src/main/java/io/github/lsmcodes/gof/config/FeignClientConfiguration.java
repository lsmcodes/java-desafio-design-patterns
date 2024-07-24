package io.github.lsmcodes.gof.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignClientConfiguration {
        
        @Bean
        ErrorDecoder errorDecoder() {
                return new CustomErrorDecoder();
        }

}