package com.blyl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blyl.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public String userLogin(@RequestBody User user) {
		String username=null;
		String password=null;
		username=user.getUsername();
		password=user.getPassword();
		System.out.println(user.toString());
		ObjectMapper objectMapper = new ObjectMapper();
	
		if ("admin".equals(username) && "123".equals(password)) {
			try {
				
				String json=objectMapper.writeValueAsString(new User(username, password));
				System.out.println(json);
				return json;
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	@RequestMapping(value="/getOne",method=RequestMethod.GET)
	@ResponseBody
	public String getUser() throws JsonProcessingException{
		System.out.println(".....................");
		User user=new User("ad","as");
		ObjectMapper objectMapper = new ObjectMapper();
		String json=objectMapper.writeValueAsString(user);
		return json;
	}
	
	@RequestMapping(value="/kaptCha",method=RequestMethod.GET)
	public ModelAndView getKaptChaImage(HttpServletRequest request,HttpServletResponse response,Model model){
		//response.setDateHeader("", arg1);
		return null;
	}
}
