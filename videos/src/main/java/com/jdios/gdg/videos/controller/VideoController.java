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

import com.jdios.gdg.videos.domain.Video;
import com.jdios.gdg.videos.service.implementation.VideoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * Video Controller
 * @author jdotero
 *
 */
@Api(value = "/api/v1/videos")
@RestController
@RequestMapping("api/v1/videos")
public class VideoController {
	
	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(VideoController.class);
	
	/**
	 * Service dependencies
	 */
	@Autowired
	private VideoServiceImpl videoService;

	/**
	 * Find a single video by id
	 * @param idVideo
	 * @return
	 */
	@ApiOperation(value="Finds a single video by id", response = Video.class)
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Video findVideoById(
			@ApiParam(name = "id", required = true, type = "Long") @PathVariable(name = "id", required = true) Long id) {	
		return this.videoService.findVideoById(id);
	}
	
	/**
	 * Creates a new video
	 * @param video
	 * @return
	 */
	@ApiOperation(value="Creates a new video", response = Video.class)
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Video addVideo(@RequestBody Video video) {
		return videoService.addVideo(video);
	}
	

	/**
	 * Update all video or a single video by id
	 * @param id
	 * @param video
	 * @return
	 */
	@ApiOperation(value = "Updates a single video, creates it if not exist", response = Video.class, responseContainer = "List")
	@PutMapping(value = {""}, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Video updateVideo(@RequestBody Video video)  {
		
		return videoService.updateVideo(video);
	}
	

	/**
	 * Delete a single video by id
	 * @param id
	 * @return
	 * @throws VideoNotFoundException 
	 */
	@ApiOperation(value = "Deletes all video or a single video by id", response = Video.class, responseContainer = "List")
	@DeleteMapping(value = "/{id}")
	public Integer deleteVideoById(
		@ApiParam(name="id", required = false, hidden = false, type = "Long") @PathVariable(name = "id", required = false) Long idVideo
	) {
		return videoService.deleteVideoById(idVideo);
	}
	
	/**
	 * Disable a video by id
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "Disables a video by id", response = Video.class)
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Video disableVideoById(
			@ApiParam(name="id", required = true, hidden = false, type = "Long")
			@RequestParam(value="id") Long id) {
		return videoService.disableVideo(id);
	}
	
	
	/**
	 * Search videos by string
	 * @param search
	 * @return
	 */
	@ApiOperation(value = "Search videos", response = Video.class, responseContainer = "List")
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Video> searchVideos(@RequestParam(value = "search") String search){
		return videoService.searchVideo(search);
	}

}
