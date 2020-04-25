package com.Kewl.coolKids.constants;

import java.util.Arrays;
import java.util.List;

import com.Kewl.coolKids.enums.Categories;
import com.Kewl.coolKids.enums.YotubeChannels;

public class KewlConstants {
	
	public static final List<Categories> CATEGORIES = Arrays.asList(Categories.values());
	
	public static final List<YotubeChannels> YOUTUBE_CHANNELS = Arrays.asList(YotubeChannels.values());
	
	public static final String SUCCESS_RESPONSE_CODE = "000";
	public static final String SUCCESS_RESPONSE_MESSAGE = "YO-YO";
	
	public static final String FAILURE_RESPONSE_CODE = "999";
	public static final String FAILURE_RESPONSE_MESSAGE = "NO-NO";
	

}
