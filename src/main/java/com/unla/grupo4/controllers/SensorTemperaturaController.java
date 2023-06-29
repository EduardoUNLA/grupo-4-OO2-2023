package com.unla.grupo4.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

import com.unla.grupo4.entities.Dispositivo;
import com.unla.grupo4.entities.SensorBasura;
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
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSOR_TEMP_INDEX);
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
	public RedirectView nuevoEvento(@ModelAttribute("evento") EventoModel evento) {
		
		
		Dispositivo nvoDispositivo=dispositivoService.findById(evento.getDispositivo().getId());
		EventoModel nvoEvento= new EventoModel(evento.getDescripcion(),evento.getFechaHora(),nvoDispositivo);
		eventoService.insertOrUpdate(nvoEvento);
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.NVO_EVENTO_TEMP);
		mAV.addObject("eventos", eventoService.getAll());
		return new RedirectView(ViewRouteHelper.EVENTOS_ROOT);

	}

	/*
	@GetMapping("/nuevoEventoT")
	public RedirectView generarEventos() {
		List<SensorTemperatura> sensores = new ArrayList<SensorTemperatura>();
		sensores = sensorTemperaturaService.comprobar(sensorTemperaturaService.getAll());
		for (int i=0; i<sensores.size(); i++) {
			sensorTemperaturaService.insertOrUpdate(sensores.get(i));
			EventoModel eventoModel = new EventoModel();
			if(i%2==0) {
				eventoModel = new EventoModel("Encender Aire",LocalDateTime.now(),sensores.get(i));
			}else {
				eventoModel = new EventoModel("Encender Calefaccion",LocalDateTime.now(),sensores.get(i));
			}
			
			eventoService.insertOrUpdate(eventoModel);
		}
		return new RedirectView(ViewRouteHelper.EVENTOS_ROOT);
	}*/
	
	@PostMapping("/nuevoSensorT")
	public RedirectView nuevoSensor(@ModelAttribute("sensor") SensorTemperaturaModel sensor) {

		sensorTemperaturaService.insertOrUpdate(sensor);
		ModelAndView mAV = new ModelAndView();
		mAV.setViewName(ViewRouteHelper.NVO_SENSOR_TEMP);
		mAV.addObject("sensores", sensorTemperaturaService.getAll());
		return new RedirectView(ViewRouteHelper.SENSORTEMP_ROOT);

	}

}
