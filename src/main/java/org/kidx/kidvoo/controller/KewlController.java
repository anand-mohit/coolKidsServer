package org.kidx.kidvoo.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.kidx.kidvoo.constants.KewlConstants;
import org.kidx.kidvoo.enums.Categories;
import org.kidx.kidvoo.model.requests.PlaylistRequest;
import org.kidx.kidvoo.model.responses.CategoryResponse;
import org.kidx.kidvoo.model.responses.CoolKidResponse;
import org.kidx.kidvoo.model.responses.PlaylistRepsonse;
import org.kidx.kidvoo.model.responses.ResponseStatus;
import org.kidx.kidvoo.services.PlaylistService;
import org.kidx.kidvoo.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KewlController {
	
	
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	VideoService videoService;

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
		List<PlaylistRepsonse> playList = categoryCode.stream()
				.map(c-> Categories.valueOf(c))
				.map(c->new PlaylistRepsonse(c.name(),c.getValue(),videoService.getVideoListByCategoryCode(c.name()))).collect(Collectors.toList());
		CoolKidResponse response = new CoolKidResponse(new ResponseStatus(KewlConstants.SUCCESS_RESPONSE_CODE,KewlConstants.SUCCESS_RESPONSE_MESSAGE),playList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	

}

