package com.Kewl.coolKids.youtubeModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Snippet {
	
	String publishedAt ;
    String channelId;
    String title;
    //String description;
    String channelTitle;
    String playlistId;
    Thumbnails thumbnails;
}
