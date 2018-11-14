package com.jdios.gdg.library.videos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Long idUser;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "video")
	private Video video;
	private Date from;
	private Date to;
	private Boolean unlimited;
	private Boolean returned;	
}
