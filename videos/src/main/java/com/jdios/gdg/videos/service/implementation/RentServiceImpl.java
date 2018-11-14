package com.jdios.gdg.videos.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdios.gdg.videos.domain.Rent;
import com.jdios.gdg.videos.repository.IRentRepository;
import com.jdios.gdg.videos.service.IRentService;


@Service
public class RentServiceImpl implements IRentService {

	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(RentServiceImpl.class);


	/**
	 * Repository Dependencies
	 */
	@Autowired
	private IRentRepository rentRepository;

	@Override
	public Rent findRentById(Long idRent) {
		Optional<Rent> rent = this.rentRepository.findById(idRent);
		if(rent.isPresent()) {
			return rent.get();
		} else {
			throw new EntityNotFoundException("The rent with id " + idRent +  " does not exists");
		}
	}

	@Override
	public List<Rent> findRentByFilter(Rent rent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rent addRent(Rent rent) {
		Rent rentSaved = null;
		if(rent.getId() == null) {
			rentSaved = rentRepository.save(rent);
		}
		return rentSaved;
	}

	@Override
	public Rent updateRent(Rent rent) {
		Rent rentSaved = null;
		if(rent.getId() == null) {
			rentSaved = rentRepository.save(rent);
		}
		return rentSaved;
	}

	@Override
	public Integer deleteRentById(Long idRent) {
		Integer countResult = rentRepository.removeById(idRent);	
		return countResult;
	}

	@Override
	public Rent disableRent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rent> searchRent(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
