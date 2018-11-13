package com.jdios.gdg.clients.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdios.gdg.clients.domain.Client;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(value = "/api/v1/clients")
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Client findUserById(
			@ApiParam(name = "id", required = true, type = "Long") @PathVariable(name = "id", required = true) Long idUser) {
		Client client = new Client();
		client.setName("Jose Juan");
		client.setSurname("Dios");
		client.setAlias("Jdios");
		return client;
	}

}
