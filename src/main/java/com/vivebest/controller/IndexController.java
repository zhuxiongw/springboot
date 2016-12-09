package com.vivebest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivebest.entity.Admin;
import com.vivebest.entity.User;
import com.vivebest.service.AdminService;
import com.vivebest.service.UserService;

@Controller

public class IndexController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	@RequestMapping("/index")
	public String index(@RequestParam(value = "username", defaultValue = "不知道", required = false) String username,
			@RequestParam(value = "name", defaultValue = "kaka", required = false) String name, Model model) {
		User user = userService.findByUsername(username);
		Admin admin = adminService.findByName(name);
		model.addAttribute("user", user);
		model.addAttribute("admin", admin);
		return "index/index";
	}
}
