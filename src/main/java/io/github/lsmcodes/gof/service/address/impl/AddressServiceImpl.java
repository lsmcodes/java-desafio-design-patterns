package io.github.lsmcodes.gof.service.address.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.lsmcodes.gof.model.address.Address;
import io.github.lsmcodes.gof.repository.address.AddressRepository;
import io.github.lsmcodes.gof.service.address.AddressService;
import io.github.lsmcodes.gof.service.viacep.ViaCepService;

@Service
public class AddressServiceImpl implements AddressService {

        @Autowired
        private ViaCepService viaCepService;

        @Autowired
        private AddressRepository addressRepository;

        @Override
        public Address findById(String cep) {
                return this.addressRepository.findById(cep).orElseGet(() -> {
                        Address newAddress = this.viaCepService.findAddress(cep);
                        return this.addressRepository.save(newAddress);
                });
        }

}