package com.care.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController//비동기 방식으로 사용 할 경우 RestController을 이용한다 

public class TestController {
	static int aaa=0;
	@GetMapping("user")//경로로 받는법("user/{name아무이름}")
	public String getUser(@RequestParam("name")String userName) {//@pathVariable String name 경로
		System.out.println("넘겨 받은 사용자 이름:"+userName);
		return "test";
	}
	
	
	
	/*
	static int aaa=0;
	@GetMapping(value="ajax_result",produces="application/text;charset=utf8")
//	@ResponseBody
	public ArrayList<UserDTO> ajax_result() {
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		UserDTO dto01=new UserDTO();
		UserDTO dto02=new UserDTO();
		dto01.setName("홍길동");dto01.setAge("20");
		dto01.setName("김개똥");dto01.setAge("30");
		list.add(dto01);list.add(dto02);
		//spring 에선 문자열 형태밖에 리턴값을 줄 수 있어서 list는 리턴 불가!!
		//그래서 list를 json형태로 바꿔서 보낸내준다. 밑에 추가내용임
	*/	

	@GetMapping(value="ajax_result",produces="application/json;charset=utf8")
//	@ResponseBody
	public String ajax_result() throws JsonProcessingException {
		ArrayList<UserDTO> list=new ArrayList<UserDTO>();
		UserDTO dto01=new UserDTO();
		UserDTO dto02=new UserDTO();
		dto01.setName("홍길동");dto01.setAge("20");
		dto02.setName("김개똥");dto02.setAge("30");
		list.add(dto01);list.add(dto02);
		
		ObjectMapper mapper=new ObjectMapper();
		String strJson=mapper.writeValueAsString(list);
		return strJson;
	}
	@PostMapping(value="ajax_result",produces="application/text;charset=utf8")
	public String ajax_post() {
		return "post:데이터 추가할때";
	}
	@PutMapping(value="ajax_result",produces="application/text;charset=utf8")
	public String ajax_put() {
		return "put: 데이터 수정할때";
	}
	@DeleteMapping(value="ajax_result",produces="application/text;charset=utf8")
	public String ajax_delete() {
		return "del:삭제할때";
	}


}
