package com.unla.grupo4.controllers;

import java.time.LocalDateTime;
import java.util.List;

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

import com.unla.grupo4.entities.SensorLuces;
import com.unla.grupo4.helpers.ViewRouteHelper;
import com.unla.grupo4.models.EventoModel;
import com.unla.grupo4.models.SensorLucesModel;
import com.unla.grupo4.services.IEventoService;
import com.unla.grupo4.services.ISensorLucesService;

@Controller
@RequestMapping("/sensor_luces")
public class SensorLucesController {
	@Autowired
	@Qualifier("sensorLucesService")
	private ISensorLucesService sensorLucesService;

	@Autowired
	@Qualifier("eventoService")
	private IEventoService eventoService;

	private ModelMapper modelMapper = new ModelMapper();

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORLUCES_INDEX);
		mAV.addObject("sensores", sensorLucesService.getAll());
		mAV.addObject("eventos", eventoService.getAll());
		mAV.addObject("sensorLuces", new SensorLuces());
		return mAV;
	}

	@GetMapping("/nuevo")
	public ModelAndView crear() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORLUCES_NUEVO);
		mAV.addObject("sensorLuces", new SensorLucesModel());
		return mAV;
	}

	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute("sensorLuces") SensorLucesModel sensorLucesModel) {
		sensorLucesModel.setNombre("Sensor de luces");
		sensorLucesService.insertOrUpdate(modelMapper.map(sensorLucesModel, SensorLuces.class));
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.SENSORLUCES_UPDATE);
		mAV.addObject("sensorLuces", sensorLucesService.findById(id));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("sensorLuces") SensorLucesModel sensorLucesModel) {
		SensorLuces sensorLuces = modelMapper.map(sensorLucesModel, SensorLuces.class);
		sensorLucesService.insertOrUpdate(sensorLuces);
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}

	@PostMapping("/baja")
	public RedirectView apagar(@ModelAttribute("sensorLuces") SensorLucesModel sensorLucesModel) {
		SensorLuces sensorLuces = modelMapper.map(sensorLucesModel, SensorLuces.class);
		sensorLuces.setActivo(false);
		sensorLucesService.insertOrUpdate(sensorLuces);
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}

	@PostMapping("/alta")
	public RedirectView encender(@ModelAttribute("sensorLuces") SensorLucesModel sensorLucesModel) {
		SensorLuces sensorLuces = modelMapper.map(sensorLucesModel, SensorLuces.class);
		sensorLuces.setActivo(true);
		sensorLucesService.insertOrUpdate(sensorLuces);
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		sensorLucesService.remove(id);
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}

	@GetMapping("/generar_eventos")
	public RedirectView generareventos() {
		List<SensorLuces> sensores = sensorLucesService.comprobar(sensorLucesService.findByActivo(true));
		for (int i = 0; i < sensores.size(); i++) {
			sensorLucesService.insertOrUpdate(sensores.get(i));
			if (sensores.get(i).getNivelLuz() < 50 || sensores.get(i).isGente() == true
					|| sensores.get(i).isEncendido() == false) {
				EventoModel eventoModel = new EventoModel("Encender luz", LocalDateTime.now(), sensores.get(i));
				eventoService.insertOrUpdate(eventoModel);
			} else if ((sensores.get(i).isGente() == false && sensores.get(i).getNivelLuz() > 50)
					|| sensores.get(i).isEncendido() == true) {
				EventoModel eventoModel = new EventoModel("Apagar luz", LocalDateTime.now(), sensores.get(i));
				eventoService.insertOrUpdate(eventoModel);
			}
		}
		return new RedirectView(ViewRouteHelper.SENSORLUCES_ROOT);
	}
}
