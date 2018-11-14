package com.jdios.gdg.videos.service;

import java.util.List;

import com.jdios.gdg.videos.domain.Video;





/**
 * API Video Service
 * @author jdotero
 *
 */
public interface IVideoService {
	/**
	 * Finds a single video by id
	 * @param id
	 * @return
	 * @throws VideoNotFoundException 
	 */
	public Video findVideoById(Long idVideo);
	
	
	/**
	 * Finds all videos or a single video by id
	 * @param video
	 * @return
	 */
	public List<Video> findVideoByFilter(Video video);
	
	
	/**
	 * Creates a new video
	 * @param video
	 * @return
	 */
	public Video addVideo(Video video);
	
	
	/**
	 * Updates a single video, creates it if not exist
	 * @param id
	 * @param video
	 * @return
	 * @throws VideoNotFoundException 
	 */
	public Video updateVideo(Video video);
	
	
	/**
	 * Deletes a single video by id
	 * @param id
	 * @return
	 * @throws VideoNotFoundException 
	 */
	public Integer deleteVideoById(Long idVideo);
	
	/**
	 * Disable a video
	 * @param id
	 * @return
	 * @throws VideoNotFoundException 
	 */
	public Video disableVideo(Long id);
	
	/**
	 * Search video using specification
	 * @param search
	 * @return
	 */
	public List<Video> searchVideo(String search);
}
