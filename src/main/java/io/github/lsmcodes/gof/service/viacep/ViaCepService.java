package io.github.lsmcodes.gof.service.viacep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.lsmcodes.gof.model.address.Address;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
        
        @GetMapping("/{cep}/json")
        Address findAddress(@PathVariable("cep") String cep);

}