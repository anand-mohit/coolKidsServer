package com.Kewl.coolKids.constants;

public class YoutubeConstants {
	
	public static final String DATA_API_KEY	="&key=";
	public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
	public static final String PART = "part=snippet,contentDetails,status";
	public static final String PLAYLIST_URL = BASE_URL + "playlists?"+PART;
	public static final String PLAYLIST_VIDEOLIST_URL = BASE_URL + "playlistItems?"+PART;
	public static final String MAX_RESULTS_50 = "&maxResults=50";
	public static final String PAGE_TOKEN = "&pageToken=";
	

}
