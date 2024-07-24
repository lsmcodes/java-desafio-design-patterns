package io.github.lsmcodes.gof.util;

import java.util.List;

import io.github.lsmcodes.gof.dto.model.address.AddressDTO;
import io.github.lsmcodes.gof.dto.model.client.ClientDTO;
import io.github.lsmcodes.gof.dto.model.client.ClientRegisterDTO;
import io.github.lsmcodes.gof.model.address.Address;
import io.github.lsmcodes.gof.model.client.Client;

public class GofApplicationUtil {

        public static Client getClientFromClientRegisterDTO(ClientRegisterDTO dto) {
                Address address = new Address();
                address.setCep(dto.getCep());

                Client client = dto.DTOToEntity();
                client.setAddress(address);

                return client;
        }

        public static ClientDTO getClientDTOFromClient(Client client) {
                ClientDTO clientDTO = client.entityToDTO();

                AddressDTO addressDTO = client.getAddress().entityToDTO();
                clientDTO.setAddressDTO(addressDTO);

                return clientDTO;
        }

        public static List<ClientDTO> convertClientListToClientDTOList(List<Client> clients) {
                List<ClientDTO> clientDTOs = clients.stream().map(client -> {
                        ClientDTO clientDTO = client.entityToDTO();
                        AddressDTO addressDTO = client.getAddress().entityToDTO();
                        clientDTO.setAddressDTO(addressDTO);

                        return clientDTO;
                }).toList();

                return clientDTOs;
        }

}