package io.github.lsmcodes.gof.model.address;

import org.modelmapper.ModelMapper;

import io.github.lsmcodes.gof.dto.model.address.AddressDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

        @Id
        private String cep;

        private String logradouro;
        private String complemento;
        private String unidade;
        private String bairro;
        private String localidade;
        private String uf;
        private String ibge;
        private String gia;
        private String ddd;
        private String siafi;

        public AddressDTO entityToDTO() {
                return new ModelMapper().map(this, AddressDTO.class);
        }

}