package com.unla.grupo4.controllers;

import java.util.List;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo4.entities.SensorBasura;
import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.models.EventoModel;
import com.unla.grupo4.models.SensorBasuraModel;
import com.unla.grupo4.services.IEventoService;
import com.unla.grupo4.services.ISensorBasuraService;

@Controller
@RequestMapping("/sensor_basura")
public class SensorBasuraController {

	@Autowired
	@Qualifier("sensorBasuraService")
	private ISensorBasuraService sensorBasuraService;

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORBASURA_INDEX);
		mAV.addObject("sensores", sensorBasuraService.getAll());
		mAV.addObject("eventos", eventoService.getEventosSensorBasura());
		mAV.addObject("sensorBasura", new SensorBasura());
		return mAV;
	}

	@GetMapping("/nuevo")
	public ModelAndView crear() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORBASURA_NUEVO);
		mAV.addObject("sensorBasura", new SensorBasuraModel());
		return mAV;
	}

	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute("sensorBasura") SensorBasuraModel sensorBasuraModel) {
		sensorBasuraModel.setActivo(true);
		sensorBasuraModel.setDistanciaBasura(1);
		sensorBasuraModel.setNombre("Sensor Basura");
		sensorBasuraService.insertOrUpdate(modelMapper.map(sensorBasuraModel, SensorBasura.class));
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORBASURA_UPDATE);
		mAV.addObject("sensorBasura", sensorBasuraService.findById(id));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("sensorBasura") SensorBasuraModel sensorBasuraModel) {
		SensorBasura sensorBasura = modelMapper.map(sensorBasuraModel, SensorBasura.class);
		sensorBasuraService.insertOrUpdate(sensorBasura);
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@PostMapping("/baja")
	public RedirectView apagar(@ModelAttribute("sensorBasura") SensorBasuraModel sensorBasuraModel) {
		SensorBasura sensorBasura = modelMapper.map(sensorBasuraModel, SensorBasura.class);
		sensorBasura.setActivo(false);
		sensorBasuraService.insertOrUpdate(sensorBasura);
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@PostMapping("/alta")
	public RedirectView encender(@ModelAttribute("sensorBasura") SensorBasuraModel sensorBasuraModel) {
		SensorBasura sensorBasura = modelMapper.map(sensorBasuraModel, SensorBasura.class);
		sensorBasura.setActivo(true);
		sensorBasuraService.insertOrUpdate(sensorBasura);
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		sensorBasuraService.remove(id);
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@GetMapping("/generar_eventos")
	public RedirectView generareventos() {
		sensorBasuraService.generarEventos();
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

	@GetMapping("/eventos/{id}")
	public ModelAndView getEventos(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORBASURA_EVENTOS);
		mAV.addObject("eventos", eventoService.getByIdDispositivo(id));
		return mAV;
	}

	@GetMapping("/encender_todos")
	public RedirectView encenderTodos() {
		sensorBasuraService.encenderTodos();
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}
	
	@GetMapping("/apagar_todos")
	public RedirectView apagarTodos() {
		sensorBasuraService.apagarTodos();
		return new RedirectView(ViewRouteHelper.SENSORBASURA_ROOT);
	}

}
