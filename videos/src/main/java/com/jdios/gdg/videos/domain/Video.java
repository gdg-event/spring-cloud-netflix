package com.jdios.gdg.videos.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Video Model
 * @author jdotero
 *
 */
@Data
@Entity
@Table(name = "video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private Integer year;
	private Integer stockUnits;
	private Integer freeUnits;
//	private List<Rent> rentedList;
}
