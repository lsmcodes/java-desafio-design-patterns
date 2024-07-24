package io.github.lsmcodes.gof.dto.model.client;

import org.modelmapper.ModelMapper;

import io.github.lsmcodes.gof.dto.model.address.AddressDTO;
import io.github.lsmcodes.gof.model.client.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

        private Long id;
        private String name;
        private AddressDTO addressDTO;

        public Client DTOToEntity() {
                return new ModelMapper().map(this, Client.class);
        }

}