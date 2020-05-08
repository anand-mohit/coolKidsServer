package org.kidx.kidvoo.model.responses;

import org.kidx.kidvoo.abstracts.ResponseModel;

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
public class VideoMeta extends ResponseModel{
	
	String videoId ;
	String title;

}
