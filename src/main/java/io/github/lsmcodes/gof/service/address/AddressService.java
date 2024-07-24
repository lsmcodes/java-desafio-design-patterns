package io.github.lsmcodes.gof.service.address;

import io.github.lsmcodes.gof.model.address.Address;

public interface AddressService {

        Address findById(String cep);

}