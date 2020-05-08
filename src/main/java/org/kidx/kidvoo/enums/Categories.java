package org.kidx.kidvoo.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Categories  {
    NURSERY_RHYMES("Nursery Rhymes","PLlBJ7nAOcqHVa5DcVuvOStJb3tALYVRyk"),
    BEDTIME_STORIES("Bedtime Stories","PLlBJ7nAOcqHWAd2g0rNwpODSVEdun6lW8"),
    BASIC_LEARNING("Learning Videos","PLlBJ7nAOcqHXP-rXch5KPAkmgZBwOS9Lz"),
    ADVANCED_LEARNING("Advanced Learning Videos","PLlBJ7nAOcqHWhOafDtTr8PS9FMQfC2Ei8"),
    KIDS_MUSIC("Kids Music","PLlBJ7nAOcqHWlsjN_gTnL-L3EeBq-luXN"),
    ;
    public String getValue() {
		return value;
	}

	public String getPlaylistId() {
		return playlistId;
	}

	String value;
	String playlistId;
}
