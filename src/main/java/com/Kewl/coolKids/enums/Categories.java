package com.Kewl.coolKids.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum Categories  {
    NURSERY_RHYMES("Nursery Rhymes"),
    BEDTIME_STORIES("Bedtime Stories"),
    LEARNING_VIDEOS("Learning Videos"),
    ADVANCED_LEARNING_VIDEOS("Advanced Learning Videos"),
    ;
    public String getValue() {
		return value;
	}

	String value;
}
