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
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo4.entities.SensorTemperatura;
import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.models.EventoModel;
import com.unla.grupo4.models.SensorTemperaturaModel;
import com.unla.grupo4.services.IDispositivoService;
import com.unla.grupo4.services.IEventoService;
import com.unla.grupo4.services.ISensorTemperaturaService;

@Controller
@RequestMapping("/sensor_temperatura")
public class SensorTemperaturaController {

	@Autowired
	@Qualifier("sensorTemperaturaService")
	private ISensorTemperaturaService sensorTemperaturaService;

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;
	
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORTEMP_ROOT);
		mAV.addObject("sensores", sensorTemperaturaService.getAll());
		mAV.addObject("eventos", eventoService.getAll());
		mAV.addObject("sensorTemperatura", new SensorTemperatura());
		
		return mAV;
	}

	@GetMapping("/altaSensorT")
	public String altaSensorT(Model model) {

		model.addAttribute("sensor", new SensorTemperaturaModel());
		return ViewRouteHelper.ALTA_SENSOR_TEMP_FORM;
	}

	@GetMapping("/altaEventoT")
	public String altaEventoT(Model model) {

		model.addAttribute("evento", new EventoModel());
		return ViewRouteHelper.ALTA_EVENTO_TEMP_FORM;
	}

	@PostMapping("/nuevoEventoT")
	public ModelAndView nuevoEvento(@ModelAttribute("evento") EventoModel evento) {
		
		//(evento.getDispositivo().getId())
		EventoModel nvoEvento = new EventoModel(evento.getDescripcion(),evento.getFechaHora(),
				dispositivoService.findById(evento.getDispositivo().getId()));
		eventoService.insertOrUpdate(nvoEvento);
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.NVO_EVENTO_TEMP);
		mAV.addObject("eventos", eventoService.getAll());
		return mAV;

	}

	@PostMapping("/nuevoSensorT")
	public RedirectView nuevoSensorT(@ModelAttribute("sensor") SensorTemperaturaModel sensor) {

		sensorTemperaturaService.insertOrUpdate(sensor);
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.NVO_SENSOR_TEMP);
		mAV.addObject("sensores", sensorTemperaturaService.getAll());
		return new RedirectView(ViewRouteHelper.SENSORTEMP_ROOT);

	}

}
