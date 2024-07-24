package io.github.lsmcodes.gof.repository.address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.lsmcodes.gof.model.address.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}