package com.Kewl.coolKids.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum YotubeChannels {
	
	CHUCHU_TV("UC7fk9tVVNRZAjhjps2O4Ygg"),
    KIDS_LEARNING("KidsLearning"),
    ;
    public String getValue() {
		return value;
	}

	String value;
}
