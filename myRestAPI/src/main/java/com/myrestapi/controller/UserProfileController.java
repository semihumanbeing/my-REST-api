package com.myrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.mapper.UserProfileMapper;
import com.myrestapi.model.UserProfile;

@RestController // 해당 어노테이션을 걸어주면 스프링이 자동으로 이 클래스를 컨트롤러로 인식시킨다.
public class UserProfileController {
	
	private UserProfileMapper mapper;
	
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	// 아이디를 인자로 받아서 해당 userProfile의 정보를 json 형태로 전달하는 api
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return mapper.getUserProfile(id);
	}
	
	// 리스트 전체를 리턴하는 api
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		return mapper.getUserProfileList();
	}
	
	// 데이터를 생성하는 api
	@PostMapping("/user/{id}")
	public int postUserProfile(@PathVariable("id")String id, 
								@RequestParam("name")String name, 
								@RequestParam("phone") String phone, 
								@RequestParam("address") String address) {
		return mapper.insertUserProfile(id, name, phone, address);
	}
		
	
	// 데이터를 수정하는 api
	@PutMapping("/user/{id}")
	public int putUserProfile(@PathVariable("id")String id, 
							  @RequestParam("name")String name, 
							  @RequestParam("phone") String phone, 
							  @RequestParam("address") String address) {
		return mapper.updateUserProfile(id, name, phone, address);
	}
	
	// 데이터를 삭제하는 api
	@DeleteMapping("user/{id}")
	public int deleteUserProfile(@PathVariable("id") String id) {
		return mapper.deleteUserProfile(id);
	}

}
