package com.jdios.gdg.videos.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


/**
 * Rent Video Model
 * @author jdotero
 *
 */
@Data
@Entity
public class Rent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Boolean unlimited;
	private Boolean returned;	
}
