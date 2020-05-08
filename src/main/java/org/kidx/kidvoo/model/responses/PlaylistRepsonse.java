package org.kidx.kidvoo.model.responses;

import java.util.List;

import org.kidx.kidvoo.abstracts.ResponseModel;
import org.kidx.kidvoo.model.VideoDao;

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
public class PlaylistRepsonse extends ResponseModel{
	String categoryCode;
	String categoryName;
	List<VideoDao> playlist;
}
