package io.github.lsmcodes.gof.service.client;

import io.github.lsmcodes.gof.exception.ClientNotFoundException;
import io.github.lsmcodes.gof.model.client.Client;

public interface ClientService {
        
        Iterable<Client> findAll();
        Client findById(Long id) throws ClientNotFoundException;
        Client save(Client client);
        Client update(Long id, Client client) throws ClientNotFoundException;
        void delete(Client client);

}