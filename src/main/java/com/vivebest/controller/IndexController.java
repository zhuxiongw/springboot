package com.vivebest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivebest.entity.User;
import com.vivebest.service.UserService;

@Controller

public class IndexController {
	@Autowired
	private UserService userService;
	@RequestMapping("/index")
	public String index(@RequestParam(value="username",defaultValue="不知道",required=false)String username,Model model){
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "/index/index";
	}
}
