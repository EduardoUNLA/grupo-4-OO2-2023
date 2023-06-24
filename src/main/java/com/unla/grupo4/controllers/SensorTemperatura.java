package com.unla.grupo4.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.models.SensorTemperaturaModel;
import com.unla.grupo4.services.ISensorTemperaturaService;



@Controller
@RequestMapping("/sensores")
public class SensorTemperatura {

	@Autowired
	@Qualifier("sensorTemperaturaService")
	private ISensorTemperaturaService sensorTemperaturaService;
	
	@GetMapping("/altaSensorT")
	public String altaSensor(Model model) {
		
		model.addAttribute("sensor", new SensorTemperaturaModel());
		return ViewRouteHelper.ALTA_SENSOR_TEMP_FORM;
	}

	@PostMapping("/nuevoSensorT")
	public ModelAndView nuevoSensor(@ModelAttribute("sensor") SensorTemperaturaModel sensor) {
		
		sensorTemperaturaService.insertOrUpdate(sensor);
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.NVO_SENSOR_TEMP);
		mAV.addObject("listaSensores", sensorTemperaturaService.getAll());
		return mAV;

	}
 
	
	/*
	 * (@Valid @ModelAttribute("persona")PersonaModelo persona,BindingResult b)
	 * if(b.hasErrors()) {
	 * 
	 * mV.setViewName(ViewRouteHelper.PERSONA_FORM);
	 * 
	 * }else { //personaService.insertOrUpdate(persona);
	 * 
	 * mV.setViewName(ViewRouteHelper.PERSONA_NEW); mV.addObject("persona",
	 * persona);
	 * 
	 * //mV.addObject("listaPersonas", personaService.getAll());
	 * 
	 * }
	 */

}
