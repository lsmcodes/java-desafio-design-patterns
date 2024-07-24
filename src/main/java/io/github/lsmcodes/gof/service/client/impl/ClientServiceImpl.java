package io.github.lsmcodes.gof.service.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.lsmcodes.gof.exception.ClientNotFoundException;
import io.github.lsmcodes.gof.model.address.Address;
import io.github.lsmcodes.gof.model.client.Client;
import io.github.lsmcodes.gof.repository.client.ClientRepository;
import io.github.lsmcodes.gof.service.address.AddressService;
import io.github.lsmcodes.gof.service.client.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

        @Autowired
        private ClientRepository clientRepository;

        @Autowired
        private AddressService addressService;

        @Override
        public Iterable<Client> findAll() {
                return this.clientRepository.findAll();
        }

        @Override
        public Client findById(Long id) throws ClientNotFoundException {
                return this.clientRepository.findById(id).orElseThrow(
                                () -> new ClientNotFoundException("There is no client registered with the id " + id));
        }

        @Override
        public Client save(Client client) {
                Address address = this.addressService.findById(client.getAddress().getCep());
                client.setAddress(address);

                return this.clientRepository.save(client);
        }

        @Override
        public Client update(Long id, Client client) throws ClientNotFoundException {
                Client foundClient = this.clientRepository.findById(id).orElseThrow(
                                () -> new ClientNotFoundException("There is no client registered with the id " + id));

                Address foundAddress = this.addressService.findById(client.getAddress().getCep());

                foundClient.setName(client.getName());
                foundClient.setAddress(foundAddress);

                this.save(foundClient);

                return foundClient;
        }

        @Override
        public void delete(Client client) {
                this.clientRepository.delete(client);
        }

}