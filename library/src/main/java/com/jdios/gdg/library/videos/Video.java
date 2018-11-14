package com.jdios.gdg.library.videos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Video Model
 * @author jdotero
 *
 */
@Data
@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private Integer year;
	private Integer stockUnits;
	private Integer freeUnits;
	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	private List<Rent> rentedList;
}
