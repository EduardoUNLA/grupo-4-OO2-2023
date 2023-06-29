package com.unla.grupo4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.services.IEventoService;

@Controller
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_INDEX);
		mAV.addObject("eventos", eventoService.getAll());
		return mAV;
	}
}
