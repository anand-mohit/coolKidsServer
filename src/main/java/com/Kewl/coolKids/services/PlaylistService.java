package com.Kewl.coolKids.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Kewl.coolKids.model.responses.VideoMeta;

@Service
public class PlaylistService {
	
	public List<VideoMeta> getPlayList(String categoryCode){
		return Arrays.asList(new VideoMeta("DwrHwZyFN7M","Fast Car"));
	}

}
