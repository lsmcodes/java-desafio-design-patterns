package io.github.lsmcodes.gof.dto.model.client;

import org.modelmapper.ModelMapper;

import io.github.lsmcodes.gof.model.client.Client;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRegisterDTO {

        @NotNull(message = "Name cannot be null")
        private String name;

        @NotNull(message = "CEP cannot be null")
        private String cep;

        public Client DTOToEntity() {
                return new ModelMapper().map(this, Client.class);
        }

}