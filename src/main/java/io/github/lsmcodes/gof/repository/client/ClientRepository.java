package io.github.lsmcodes.gof.repository.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.lsmcodes.gof.model.client.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

}