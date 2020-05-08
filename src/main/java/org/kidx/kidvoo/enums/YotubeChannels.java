package org.kidx.kidvoo.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum YotubeChannels {
	
	CHUCHU_TV("UC7fk9tVVNRZAjhjps2O4Ygg"),
    COOL_KIDS("UCdHCmXZKmodh2i3Ut_WrnNg"),
    ;
    public String getValue() {
		return value;
	}

	String value;
}
