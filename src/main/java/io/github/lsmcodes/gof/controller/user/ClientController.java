package io.github.lsmcodes.gof.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.lsmcodes.gof.dto.model.client.ClientDTO;
import io.github.lsmcodes.gof.dto.model.client.ClientRegisterDTO;
import io.github.lsmcodes.gof.dto.response.Response;
import io.github.lsmcodes.gof.exception.ClientNotFoundException;
import io.github.lsmcodes.gof.model.client.Client;
import io.github.lsmcodes.gof.service.client.ClientService;
import io.github.lsmcodes.gof.util.GofApplicationUtil;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/clients")
public class ClientController {

        @Autowired
        private ClientService clientService;

        @PostMapping
        public ResponseEntity<Response<ClientDTO>> save(@RequestBody @Valid ClientRegisterDTO dto, BindingResult result) {
                Response<ClientDTO> response = new Response<>();

                if(result.hasErrors()) {
                        result.getAllErrors().stream().forEach(error -> response.addErrorsToResponse(400, error.getDefaultMessage()));
                        
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }

                Client client = GofApplicationUtil.getClientFromClientRegisterDTO(dto);
                client = clientService.save(client);

                ClientDTO clientDTO = GofApplicationUtil.getClientDTOFromClient(client);
                response.setData(clientDTO);

                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        @GetMapping
        public ResponseEntity<Response<List<ClientDTO>>> findAll() {
                Response<List<ClientDTO>> response = new Response<>();

                List<Client> foundClients = (List<Client>) this.clientService.findAll();
                List<ClientDTO> clientDTOs = GofApplicationUtil.convertClientListToClientDTOList(foundClients);

                response.setData(clientDTOs);
                
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Response<ClientDTO>> findById(@PathVariable Long id) throws ClientNotFoundException {
                Response<ClientDTO> response = new Response<>();

                Client foundClient = this.clientService.findById(id);
                ClientDTO clientDTO = GofApplicationUtil.getClientDTOFromClient(foundClient);

                response.setData(clientDTO);
                
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Response<ClientDTO>> update(@PathVariable Long id, @RequestBody @Valid ClientRegisterDTO dto, BindingResult result) throws ClientNotFoundException {
                Response<ClientDTO> response = new Response<>();

                if(result.hasErrors()) {
                        result.getAllErrors().stream().forEach(error -> response.addErrorsToResponse(400, error.getDefaultMessage()));
                        
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                }

                Client updatedClient = this.clientService.update(id, GofApplicationUtil.getClientFromClientRegisterDTO(dto));
                ClientDTO clientDTO = GofApplicationUtil.getClientDTOFromClient(updatedClient);

                response.setData(clientDTO);
                
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Response<String>> delete(@PathVariable Long id) throws ClientNotFoundException {
                Response<String> response = new Response<>();

                Client client = this.clientService.findById(id);
                this.clientService.delete(client);

                response.setData("Client with id " + id + " was deleted successfully");
                
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

}