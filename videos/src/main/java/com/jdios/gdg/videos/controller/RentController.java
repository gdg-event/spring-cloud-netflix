package com.jdios.gdg.videos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.jdios.gdg.videos.domain.Rent;
import com.jdios.gdg.videos.service.implementation.RentServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/api/v1/videos/rents")
@RestController
@RequestMapping("api/v1/videos/rents")
public class RentController {
	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(RentController.class);
	
	/**
	 * Service dependencies
	 */
	@Autowired
	private RentServiceImpl rentService;

	/**
	 * Find a single rent by id
	 * @param idRent
	 * @return
	 */
	@ApiOperation(value="Finds a single rent by id", response = Rent.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Rent findRentById(
			@ApiParam(name = "id", required = true, type = "Long") @PathVariable(name = "id", required = true) Long id) {	
		return this.rentService.findRentById(id);
	}
	
	/**
	 * Creates a new rent
	 * @param rent
	 * @return
	 */
	@ApiOperation(value="Creates a new rent", response = Rent.class)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Rent addRent(@RequestBody Rent rent) {
		return rentService.addRent(rent);
	}
	

	/**
	 * Update all rent or a single rent by id
	 * @param id
	 * @param rent
	 * @return
	 */
	@ApiOperation(value = "Updates a single rent, creates it if not exist", response = Rent.class, responseContainer = "List")
	@PutMapping(value = {""}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Rent updateRent(@RequestBody Rent rent)  {
		
		return rentService.updateRent(rent);
	}
	

	/**
	 * Delete a single rent by id
	 * @param id
	 * @return
	 * @throws RentNotFoundException 
	 */
	@ApiOperation(value = "Deletes all rent or a single rent by id", response = Rent.class, responseContainer = "List")
	@DeleteMapping(value = "/{id}")
	public Integer deleteRentById(
		@ApiParam(name="id", required = false, hidden = false, type = "Long") @PathVariable(name = "id", required = false) Long idRent
	) {
		return rentService.deleteRentById(idRent);
	}
	
	/**
	 * Disable a rent by id
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Disables a rent by id", response = Rent.class)
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Rent disableRentById(
			@ApiParam(name="id", required = true, hidden = false, type = "Long")
			@RequestParam(value="id") Long id) {
		return rentService.disableRent(id);
	}
	
	
	/**
	 * Search rents by string
	 * @param search
	 * @return
	 */
	@ApiOperation(value = "Search rents", response = Rent.class, responseContainer = "List")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Rent> searchRents(@RequestParam(value = "search") String search){
		return rentService.searchRent(search);
	}
}
