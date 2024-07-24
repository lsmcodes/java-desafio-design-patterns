package io.github.lsmcodes.gof.dto.model.client;

import io.github.lsmcodes.gof.dto.model.address.AddressDTO;
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

}