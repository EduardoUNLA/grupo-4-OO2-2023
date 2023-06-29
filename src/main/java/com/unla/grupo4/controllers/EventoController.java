package com.unla.grupo4.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EVENTO_INDEX);
		mAV.addObject("eventos", eventoService.getAll());
		return mAV;
	}
	
	 @PostMapping("/filtro/nombre")
	  public ModelAndView filtrarPorDispositivo(@Param("nombreDispositivo") String nombreDispositivo, ModelAndView mAV) {
		mAV.addObject("eventos", eventoService.getByNombreDispositivo(nombreDispositivo));
	    return mAV;
	 }
	 @PostMapping("/filtro/id")
	 public ModelAndView filtrarPorIdEvento(@Param("idEvento") int idEvento, ModelAndView mAV) {
		mAV.addObject("eventos", eventoService.getdById(idEvento));
	    return mAV;
	 }
	 @PostMapping("/filtro/id_dispositivo")
	 public ModelAndView filtrarPorIdDispositivo(@Param("idDispositivo") int idDispositivo, ModelAndView mAV) {
		mAV.addObject("eventos", eventoService.getByIdDispositivo(idDispositivo));
	    return mAV;
	 }
	 @PostMapping("/filtro/estado_dispositivo")
	 public ModelAndView filtrarPorEstadoDispositivo(@Param("estadoDispositivo") boolean estadoDispositivo, ModelAndView mAV) {
		mAV.addObject("eventos", eventoService.getByDispositivoActivo(estadoDispositivo));
	    return mAV;
	 }
}
