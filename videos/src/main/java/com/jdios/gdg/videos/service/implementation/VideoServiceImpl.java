package com.jdios.gdg.videos.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdios.gdg.videos.domain.Video;
import com.jdios.gdg.videos.repository.IVideoRepository;
import com.jdios.gdg.videos.service.IVideoService;


@Service
public class VideoServiceImpl implements IVideoService {

	/**
	 * The logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(VideoServiceImpl.class);


	/**
	 * Repository Dependencies
	 */
	@Autowired
	private IVideoRepository videoRepository;

	@Override
	public Video findVideoById(Long idVideo) {
		Optional<Video> video = this.videoRepository.findById(idVideo);
		if(video.isPresent()) {
			return video.get();
		} else {
			throw new EntityNotFoundException("The video with id " + idVideo +  " does not exists");
		}
	}

	@Override
	public List<Video> findVideoByFilter(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video addVideo(Video video) {
		Video videoSaved = null;
		if(video.getId() == null) {
			videoSaved = videoRepository.save(video);
		}
		return videoSaved;
	}

	@Override
	public Video updateVideo(Video video) {
		Video videoSaved = null;
		if(video.getId() == null) {
			videoSaved = videoRepository.save(video);
		}
		return videoSaved;
	}

	@Override
	public Integer deleteVideoById(Long idVideo) {
		Integer countResult = videoRepository.removeById(idVideo);	
		return countResult;
	}

	@Override
	public Video disableVideo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> searchVideo(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
