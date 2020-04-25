package com.Kewl.coolKids.model.responses;

import java.util.List;

import com.Kewl.coolKids.abstracts.ResponseModel;

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
public class CoolKidResponse {
	
	ResponseStatus responseStatus;
	List<? extends ResponseModel> responses;

}
