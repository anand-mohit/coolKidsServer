package com.Kewl.coolKids.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Kewl.coolKids.constants.KewlConstants;
import com.Kewl.coolKids.enums.Categories;
import com.Kewl.coolKids.model.requests.PlaylistRequest;
import com.Kewl.coolKids.model.responses.CategoryResponse;
import com.Kewl.coolKids.model.responses.CoolKidResponse;
import com.Kewl.coolKids.model.responses.PlaylistRepsonse;
import com.Kewl.coolKids.model.responses.ResponseStatus;
import com.Kewl.coolKids.services.PlaylistService;

@RestController
public class KewlController {
	
	
	@Autowired
	PlaylistService playlistService;

	@GetMapping("/getCategories")
	public ResponseEntity<CoolKidResponse> getCategory() {
		List<Categories> categories =  KewlConstants.CATEGORIES;
		List<CategoryResponse> categoryList = categories.stream().map(cat-> new CategoryResponse(cat.name(),cat.getValue())).collect(Collectors.toList());
		CoolKidResponse response = new CoolKidResponse(new ResponseStatus(KewlConstants.SUCCESS_RESPONSE_CODE,KewlConstants.SUCCESS_RESPONSE_MESSAGE),categoryList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/getPlaylist")
	public ResponseEntity<CoolKidResponse> getPlaylist(@RequestBody PlaylistRequest playlistRequest) {
		List<String> categoryCode = playlistRequest.getCategoryCode();
		List<PlaylistRepsonse> playList = categoryCode.stream().map(c->new PlaylistRepsonse(c,playlistService.fetchVideos(c))).collect(Collectors.toList());
		CoolKidResponse response = new CoolKidResponse(new ResponseStatus(KewlConstants.SUCCESS_RESPONSE_CODE,KewlConstants.SUCCESS_RESPONSE_MESSAGE),playList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	

}

