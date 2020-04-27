package com.Kewl.coolKids.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kewl.coolKids.constants.YoutubeConstants;
import com.Kewl.coolKids.youtubeModel.Item;
import com.Kewl.coolKids.youtubeModel.YoutubeApiResponse;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistListResponse;


@Service
public class YoutubeDataService {
	
	
	@Autowired
	static RestCallService restCallService;
	
	 private static final String CLIENT_SECRETS= "/client_secret.json";
	    private static final Collection<String> SCOPES = Arrays.asList("https://www.googleapis.com/auth/youtube.readonly");

	    private static final String APPLICATION_NAME = "coolKids";
	    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	    /**
	     * Create an authorized Credential object.
	     *
	     * @return an authorized Credential object.
	     * @throws IOException
	     */
	    public static Credential authorize(final NetHttpTransport httpTransport) throws IOException {
	        // Load client secrets.
	        InputStream in = YoutubeDataService.class.getResourceAsStream(CLIENT_SECRETS);
	        GoogleClientSecrets clientSecrets =
	          GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
	        // Build flow and trigger user authorization request.
	        GoogleAuthorizationCodeFlow flow =
	            new GoogleAuthorizationCodeFlow.Builder(httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
	            .build();
	        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	        return credential;
	    }

	    /**
	     * Build and return an authorized API client service.
	     *
	     * @return an authorized API client service
	     * @throws GeneralSecurityException, IOException
	     */
	    public static YouTube getService() throws GeneralSecurityException, IOException {
	        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	        Credential credential = authorize(httpTransport);
	        return new YouTube.Builder(httpTransport, JSON_FACTORY, credential)
	            .setApplicationName(APPLICATION_NAME)
	            .build();
	    }

	    /**
	     * Call function to create API service object. Define and
	     * execute API request. Print API response.
	     *
	     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
	     */
	    public static PlaylistListResponse fetchPlaylistofChannel(String channelId) {
	    	 YouTube youtubeService;
			try {
				youtubeService = getService();
				 YouTube.Playlists.List request = youtubeService.playlists()
			             .list("id");
			         PlaylistListResponse response = request.setChannelId(channelId).execute();
			         return response;
			} catch (GeneralSecurityException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	        
			
	    }
	    
	    
	    public static YoutubeApiResponse getPlaylistOfChannel(String channelId) {
	    	String channel = "&channelId="+channelId;
	    	
	    	String url = YoutubeConstants.PLAYLIST_URL + channel + YoutubeConstants.MAX_RESULTS_50 + YoutubeConstants.DATA_API_KEY;
	    	return (YoutubeApiResponse) restCallService.makeGetHttpCall(url,YoutubeApiResponse.class).getBody(); 
	    	
	    	
	    }
	    
	    private static List<Item> getVideos(String playlistId, String pageToken,List<Item> videoItems){
	    	String playList = "&playlistId="+playlistId;
	    	String url = YoutubeConstants.PLAYLIST_VIDEOLIST_URL + playList + YoutubeConstants.MAX_RESULTS_50 + YoutubeConstants.DATA_API_KEY;
	    	url = pageToken != null ? url + YoutubeConstants.PAGE_TOKEN+pageToken :url;
	    	YoutubeApiResponse res = (YoutubeApiResponse) restCallService.makeGetHttpCall(url,YoutubeApiResponse.class).getBody(); 
	    	videoItems.addAll(res.getItems());
	    	if(res.getNextPageToken() != null) {	
	    		getVideos( playlistId,  res.getNextPageToken(), videoItems);
	    	}
			return videoItems;
	    	
	    }
	    public static List<Item> getVideosOfPlaylist(String playlistID) {
	    	return getVideos(playlistID,null,new ArrayList<> ());
	    }
	
		
	

}
