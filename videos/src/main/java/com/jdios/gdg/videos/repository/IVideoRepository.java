package com.jdios.gdg.videos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdios.gdg.videos.domain.Video;


/**
 * Video Repository
 * 
 * @author jdotero
 *
 */
@Repository
public interface IVideoRepository extends JpaRepository<Video, Long> {
	@Transactional
	public Integer removeById(Long idClient);
}
