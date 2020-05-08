package org.kidx.kidvoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table
public class VideoDao {
	@Id
	@GeneratedValue
	int id;
	@Column
	String title;
	@Column
	String videoId;
	@Column
	String categoryCode;
	@Column
	String thumbnailUrl;

}
