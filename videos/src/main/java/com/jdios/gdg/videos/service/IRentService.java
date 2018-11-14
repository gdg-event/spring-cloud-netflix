package com.jdios.gdg.videos.service;

import java.util.List;

import com.jdios.gdg.videos.domain.Rent;


/**
 * Interface Rent Service
 * @author jdotero
 *
 */
public interface IRentService {
	/**
	 * Finds a single rent by id
	 * @param id
	 * @return
	 * @throws RentNotFoundException 
	 */
	public Rent findRentById(Long idRent);
	
	
	/**
	 * Finds all rents or a single rent by id
	 * @param rent
	 * @return
	 */
	public List<Rent> findRentByFilter(Rent rent);
	
	
	/**
	 * Creates a new rent
	 * @param rent
	 * @return
	 */
	public Rent addRent(Rent rent);
	
	
	/**
	 * Updates a single rent, creates it if not exist
	 * @param id
	 * @param rent
	 * @return
	 * @throws RentNotFoundException 
	 */
	public Rent updateRent(Rent rent);
	
	
	/**
	 * Deletes a single rent by id
	 * @param id
	 * @return
	 * @throws RentNotFoundException 
	 */
	public Integer deleteRentById(Long idRent);
	
	/**
	 * Disable a rent
	 * @param id
	 * @return
	 * @throws RentNotFoundException 
	 */
	public Rent disableRent(Long id);
	
	/**
	 * Search rent using specification
	 * @param search
	 * @return
	 */
	public List<Rent> searchRent(String search);
}
