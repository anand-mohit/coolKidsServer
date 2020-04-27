package com.Kewl.coolKids.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kewl.coolKids.enums.YotubeChannels;
import com.Kewl.coolKids.youtubeModel.Item;
import com.Kewl.coolKids.youtubeModel.YoutubeApiResponse;

@Service
public class PlaylistService {

	@Autowired
	YoutubeDataService youtubeDataService;
	
	public List<YoutubeApiResponse> getYoutubePlayList(String categoryCode){
		List<String>channelIdList = getChannelList(categoryCode);
		return channelIdList.stream().map(cId->youtubeDataService.getPlaylistOfChannel(cId)).collect(Collectors.toList());
	}
	
	public List<Item> getYoutubeVideoList(String playlistId){
		List<Item> res= youtubeDataService.getVideosOfPlaylist(playlistId);
		return res;
	}
	
	public List<Item> getVideoMeta(String categoryCode){
		return getYoutubePlayList(categoryCode).stream()
				.map(p->p.getItems())
				.flatMap(List::stream)
				.map(a->getYoutubeVideoList(a.getId()))
				.flatMap(List::stream)
				.collect(Collectors.toList());

	}

	private List<String> getChannelList(String categoryCode) {
		// TODO Auto-generated method stub
		return Arrays.asList(YotubeChannels.CHUCHU_TV.getValue());
	}
	
	

}
