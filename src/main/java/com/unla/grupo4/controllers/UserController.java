package com.unla.grupo4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo4.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE);
	}
	
	@GetMapping("/user_select")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_SELECT);
		return mAV;
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_ADMIN);
		return mAV;
	}
	
	@GetMapping("/auditor")
	public ModelAndView auditor() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_AUDITOR);
		return mAV;
	}
}