package com.jdios.gdg.clients.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdios.gdg.clients.aspects.LogExecutionTime;
import com.jdios.gdg.clients.repository.IClientRepository;
import com.jdios.gdg.clients.service.IClientService;
import com.jdios.gdg.library.clients.Client;

/**
 * Client Service Implementation
 * 
 * @author jdotero
 *
 */
@Service
public class ClientServiceImpl implements IClientService {
	
	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);


	/**
	 * Repository Dependencies
	 */
	@Autowired
	private IClientRepository clientRepository;

	@Override
	@LogExecutionTime
	public Client findClientById(Long idClient) {
		Optional<Client> client = this.clientRepository.findById(idClient);
		if(client.isPresent()) {
			return client.get();
		} else {
			throw new EntityNotFoundException("The client with id " + idClient +  " does not exists");
		}
	}

	@Override
	public List<Client> findClientByFilter(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@LogExecutionTime
	public Client addClient(Client client) {
		Client clientSaved = null;
		if(client.getId() == null) {
			clientSaved = clientRepository.save(client);
		}
		return clientSaved;
	}

	@Override
	public Client updateClient(Client client) {
		Client clientSaved = null;
		if(client.getId() == null) {
			clientSaved = clientRepository.save(client);
		}
		return clientSaved;
	}

	@Override
	public Integer deleteClientById(Long idClient) {
		Integer countResult = clientRepository.removeById(idClient);
		
		return null;
	}

	@Override
	public Client disableClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchClient(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
