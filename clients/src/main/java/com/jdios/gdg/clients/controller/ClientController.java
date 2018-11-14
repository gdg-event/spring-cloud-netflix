package com.jdios.gdg.clients.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdios.gdg.clients.config.PropertiesConfig;
import com.jdios.gdg.clients.service.implementation.ClientServiceImpl;
import com.jdios.gdg.library.clients.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/api/v1/clients")
@RestController
@RequestMapping("api/v1/clients")
//@RefreshScope
public class ClientController {
	
	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(ClientController.class);
	
	/**
	 * Service dependencies
	 */
	@Autowired
	private ClientServiceImpl clientService;
	
	@Value("${greeting}")
	private String greeting;

	/**
	 * Find a single client by id
	 * @param idClient
	 * @return
	 */
	@ApiOperation(value="Finds a single client by id", response = Client.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Client findClientById(
			@ApiParam(name = "id", required = true, type = "Long") @PathVariable(name = "id", required = true) Long id) {	
		return this.clientService.findClientById(id);
	}
	
	/**
	 * Creates a new client
	 * @param client
	 * @return
	 */
	@ApiOperation(value="Creates a new client", response = Client.class)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Client addClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}
	

	/**
	 * Update all client or a single client by id
	 * @param id
	 * @param client
	 * @return
	 */
	@ApiOperation(value = "Updates a single client, creates it if not exist", response = Client.class, responseContainer = "List")
	@PutMapping(value = {""}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Client updateClient(@RequestBody Client client)  {
		
		return clientService.updateClient(client);
	}
	

	/**
	 * Delete a single client by id
	 * @param id
	 * @return
	 * @throws ClientNotFoundException 
	 */
	@ApiOperation(value = "Deletes all client or a single client by id", response = Client.class, responseContainer = "List")
	@DeleteMapping(value = "/{id}")
	public Integer deleteClientById(
		@ApiParam(name="id", required = false, hidden = false, type = "Long") @PathVariable(name = "id", required = false) Long idClient
	) {
		return clientService.deleteClientById(idClient);
	}
	
	/**
	 * Disable a client by id
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Disables a client by id", response = Client.class)
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Client disableClientById(
			@ApiParam(name="id", required = true, hidden = false, type = "Long")
			@RequestParam(value="id") Long id) {
		return clientService.disableClient(id);
	}
	
	
	/**
	 * Search clients by string
	 * @param search
	 * @return
	 */
	@ApiOperation(value = "Search clients", response = Client.class, responseContainer = "List")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> searchClients(@RequestParam(value = "search") String search){
		return clientService.searchClient(search);
	}
	
	/**
	 * Get Greeting
	 * @param search
	 * @return
	 */
	@ApiOperation(value = "Get Greeting", response = String.class)
	@GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
	public String greeting(){
		return greeting;
	}

}
