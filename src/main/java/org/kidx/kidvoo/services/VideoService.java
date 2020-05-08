package org.kidx.kidvoo.services;

import java.util.ArrayList;
import java.util.List;

import org.kidx.kidvoo.model.VideoDao;
import org.kidx.kidvoo.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

	@Autowired
	VideoRepository videoRepository;

	// getting all video records
	public List<VideoDao> getAllvideo() {
		List<VideoDao> videos = new ArrayList<VideoDao>();
		videoRepository.findAll().forEach(video -> videos.add(video));
		return videos;
	}

	// getting a specific record
	public VideoDao getvideoById(int id) {
		return videoRepository.findById(id).get();
	}

	public List<VideoDao> getVideoListByCategoryCode(String code) {
		return videoRepository.findByCategoryCode(code);
	}

	public VideoDao saveOrUpdate(VideoDao video) {
		return videoRepository.save(video);
	}

	// deleting a specific record
	public void delete(int id) {
		videoRepository.deleteById(id);
	}
}