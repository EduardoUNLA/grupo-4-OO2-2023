package com.unla.grupo4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.services.IDispositivoService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.DISPOSITIVO_INDEX);
		mAV.addObject("dispositivos",dispositivoService.getAll());
		return mAV;
	}
	
}
