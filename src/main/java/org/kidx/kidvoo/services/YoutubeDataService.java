package org.kidx.kidvoo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.kidx.kidvoo.constants.KewlConstants;
import org.kidx.kidvoo.constants.YoutubeConstants;
import org.kidx.kidvoo.enums.Categories;
import org.kidx.kidvoo.model.VideoDao;
import org.kidx.kidvoo.youtubeModel.Item;
import org.kidx.kidvoo.youtubeModel.YoutubeApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class YoutubeDataService {

	@Value("${youtube.apikey}")
	private String youtubeKey;

	@Autowired
	static RestCallService restCallService;

	@Autowired
	VideoService videoService;

	@PostConstruct
	public void getVideosOfPlaylist() {
		List<Categories> categories = KewlConstants.CATEGORIES;
		categories.forEach(category -> {
			List<Item> items = getVideos(category.getPlaylistId(), null, new ArrayList<>());
			if (!items.isEmpty()) {
				System.out.println("Posting for category - "+ category.name());
				List<VideoDao> videoList = items.stream()
						.filter(item -> item != null && item.getContentDetails() != null && item.getSnippet() != null
								&& item.getSnippet().getThumbnails() != null
								&& item.getSnippet().getThumbnails().getStandard() != null)
						.map(item -> constructVideo(item, category)).map(video -> videoService.saveOrUpdate(video))
						.collect(Collectors.toList());
			}
		});

	}

	public VideoDao constructVideo(Item item, Categories categoryCode) {
		VideoDao video = new VideoDao();
		video.setCategoryCode(categoryCode.name());
		video.setVideoId(item.getContentDetails().getVideoId());
		video.setTitle(item.getSnippet().getTitle());
		video.setThumbnailUrl(item.getSnippet().getThumbnails().getStandard().getUrl());
		return video;
	}

	public YoutubeApiResponse getPlaylistOfChannel(String channelId) {
		String channel = "&channelId=" + channelId;
		String apiKey = YoutubeConstants.DATA_API_KEY + youtubeKey;
		String url = YoutubeConstants.PLAYLIST_URL + channel + YoutubeConstants.MAX_RESULTS_50 + apiKey;
		return (YoutubeApiResponse) restCallService.makeGetHttpCall(url, YoutubeApiResponse.class).getBody();

	}

	private List<Item> getVideos(String playlistId, String pageToken, List<Item> videoItems) {
		String playList = "&playlistId=" + playlistId;
		String apiKey = YoutubeConstants.DATA_API_KEY + youtubeKey;
		String url = YoutubeConstants.PLAYLIST_VIDEOLIST_URL + playList + YoutubeConstants.MAX_RESULTS_50 + apiKey;
		url = pageToken != null ? url + YoutubeConstants.PAGE_TOKEN + pageToken : url;
		YoutubeApiResponse res = (YoutubeApiResponse) restCallService.makeGetHttpCall(url, YoutubeApiResponse.class)
				.getBody();
		videoItems.addAll(res.getItems());
		if (res.getNextPageToken() != null) {
			getVideos(playlistId, res.getNextPageToken(), videoItems);
		}
		return videoItems;

	}

	public List<Item> getVideosOfPlaylist(String playlistID) {
		return getVideos(playlistID, null, new ArrayList<>());
	}

}
