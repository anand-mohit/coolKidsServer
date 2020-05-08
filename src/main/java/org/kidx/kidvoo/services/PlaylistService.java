package org.kidx.kidvoo.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.kidx.kidvoo.enums.Categories;
import org.kidx.kidvoo.enums.YotubeChannels;
import org.kidx.kidvoo.youtubeModel.Item;
import org.kidx.kidvoo.youtubeModel.YoutubeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Item> fetchVideos(String categoryCode){
		Categories category = Categories.valueOf(categoryCode);
		List<Item> items = getYoutubeVideoList(category.getPlaylistId());
		return items;

	}
	private List<String> getChannelList(String categoryCode) {
		// TODO Auto-generated method stub
		return Arrays.asList(YotubeChannels.COOL_KIDS.getValue());
	}
	
	

}
