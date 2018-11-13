package com.jdios.gdg.clients.service;

import java.util.List;

import com.jdios.gdg.library.clients.Client;

/**
 * Client Service Interface
 * @author jdotero
 *
 */
public interface IClientService {
	/**
	 * Finds a single client by id
	 * @param id
	 * @return
	 * @throws ClientNotFoundException 
	 */
	public Client findClientById(Long idClient);
	
	
	/**
	 * Finds all clients or a single client by id
	 * @param client
	 * @return
	 */
	public List<Client> findClientByFilter(Client client);
	
	
	/**
	 * Creates a new client
	 * @param client
	 * @return
	 */
	public Client addClient(Client client);
	
	
	/**
	 * Updates a single client, creates it if not exist
	 * @param id
	 * @param client
	 * @return
	 * @throws ClientNotFoundException 
	 */
	public Client updateClient(Client client);
	
	
	/**
	 * Deletes a single client by id
	 * @param id
	 * @return
	 * @throws ClientNotFoundException 
	 */
	public Integer deleteClientById(Long idClient);
	
	/**
	 * Disable a client
	 * @param id
	 * @return
	 * @throws ClientNotFoundException 
	 */
	public Client disableClient(Long id);
	
	/**
	 * Search client using specification
	 * @param search
	 * @return
	 */
	public List<Client> searchClient(String search);

}
