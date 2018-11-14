package com.jdios.gdg.videos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdios.gdg.videos.domain.Rent;


/**
 * Rent Repository
 * @author jdotero
 *
 */
@Repository
public interface IRentRepository extends JpaRepository<Rent, Long> {
	@Transactional
	   public Integer removeById(Long idRent);
}
