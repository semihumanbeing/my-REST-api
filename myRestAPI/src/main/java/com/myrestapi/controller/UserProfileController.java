package com.myrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myrestapi.model.UserProfile;

@RestController // 해당 어노테이션을 걸어주면 스프링이 자동으로 이 클래스를 컨트롤러로 인식시킨다.
public class UserProfileController {
	private Map<String, UserProfile> userMap;
	
	@PostConstruct //  RestController가 실행되고나서 초기화 할 메서드를 지정한다.
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "김김김", "010-1111-1111", "서울시 마포구 신수동"));
		userMap.put("2", new UserProfile("2", "님님님", "010-2222-2222", "서울시 마포구 망원동"));
		userMap.put("3", new UserProfile("3", "딤딤딤", "010-3333-3333", "서울시 마포구 합정동"));
		userMap.put("4", new UserProfile("4", "림림림", "010-4444-4444", "서울시 마포구 성산동"));
	}
	
	// 아이디를 인자로 받아서 해당 userProfile의 정보를 json 형태로 전달하는 api
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	// 리스트 전체를 리턴하는 api
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList(){
		return new ArrayList<UserProfile>(userMap.values());
	}
	

}
