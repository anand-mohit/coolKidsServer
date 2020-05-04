package com.Kewl.coolKids.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Kewl.coolKids.constants.YoutubeConstants;
import com.Kewl.coolKids.youtubeModel.Item;
import com.Kewl.coolKids.youtubeModel.YoutubeApiResponse;


@Service
public class YoutubeDataService {
	
	@Value("${youtube.apikey}")
	private String youtubeKey;
	
	@Autowired
	static RestCallService restCallService;
	

	    
	    public  YoutubeApiResponse getPlaylistOfChannel(String channelId) {
	    	String channel = "&channelId="+channelId;
	    	String apiKey = YoutubeConstants.DATA_API_KEY + youtubeKey;
	    	String url = YoutubeConstants.PLAYLIST_URL + channel + YoutubeConstants.MAX_RESULTS_50 + apiKey;
	    	return (YoutubeApiResponse) restCallService.makeGetHttpCall(url,YoutubeApiResponse.class).getBody(); 
	    	
	    	
	    }
	    
	    private  List<Item> getVideos(String playlistId, String pageToken,List<Item> videoItems){
	    	String playList = "&playlistId="+playlistId;
	    	String apiKey = YoutubeConstants.DATA_API_KEY + youtubeKey;
	    	String url = YoutubeConstants.PLAYLIST_VIDEOLIST_URL + playList + YoutubeConstants.MAX_RESULTS_50 + apiKey ;
	    	url = pageToken != null ? url + YoutubeConstants.PAGE_TOKEN+pageToken :url;
	    	System.out.println(url);
	    	YoutubeApiResponse res = (YoutubeApiResponse) restCallService.makeGetHttpCall(url,YoutubeApiResponse.class).getBody(); 
	    	videoItems.addAll(res.getItems());
	    	if(res.getNextPageToken() != null) {	
	    		getVideos( playlistId,  res.getNextPageToken(), videoItems);
	    	}
			return videoItems;
	    	
	    }
	    public  List<Item> getVideosOfPlaylist(String playlistID) {
	    	return getVideos(playlistID,null,new ArrayList<> ());
	    }
	
		
	

}
