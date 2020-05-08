package org.kidx.kidvoo.youtubeModel;

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
public class Thumbnails {

	ThumbnailData medium;
	ThumbnailData standard;
	ThumbnailData high;
	
}
