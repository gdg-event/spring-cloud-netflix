package com.jdios.gdg.library.clients;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/**
 * Clients model
 * @author jdotero
 *
 */
@Data
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String surname;
	
	private String alias;
	
	private boolean enabled;

	/**
	 * Parametrized constructor
	 * @param id
	 * @param name
	 * @param surname
	 * @param alias
	 */
	public Client(Long id, String name, String surname, String alias, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.alias = alias;
		this.enabled = enabled;
	}
	
	/**
	 * Default constructor
	 * 
	 */
	public Client() {}
}
