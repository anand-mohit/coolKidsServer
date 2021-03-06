package org.kidx.kidvoo.youtubeModel;

import java.util.List;

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
public class YoutubeApiResponse {
	 String kind;
	 String etag;
	 String nextPageToken;
	 PageInfo pageInfo;
	 List<Item> items;
}
