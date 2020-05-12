package com.care.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	static int cnt=0;//데이터베이스에서 값을 가져온다 생각하자
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping("non_ajax")
	public String test() {
		System.out.println("실행!!!!!");
		return "non_ajax";
	}
	
	@RequestMapping("ajax")
	public String ajax() {
		System.out.println("실행!!!!!");
		return "ajax";
	}
	
	/*
	@GetMapping("ajax_result")
	@ResponseBody
	//jsp페이지에다 리턴값을 넘겨줄려고할 때
	//ajax를 이용할 때 ResponseBody를 꼭 써준다.
	 * json 타입은 key와 value로 이루어져 있다.
	 * 다른 방법은  @RestController 사용한다
	public String ajax_result() {
		System.out.println("ajax 실행!!!!!");
		return ++cnt + "";
	}
	*/
	
	
	
	
	
	
}
