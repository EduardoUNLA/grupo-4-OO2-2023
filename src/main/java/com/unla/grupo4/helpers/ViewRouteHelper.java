package com.unla.grupo4.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//User
	public final static String USER_SELECT = "user/user_select";
	public final static String USER_ADMIN = "user/admin";
	public final static String USER_AUDITOR = "user/auditor";
	
	//Dispositivo
	public final static String DISPOSITIVO_INDEX = "/dispositivo";
	
	//Evento
	public final static String EVENTO_INDEX= "eventos/index";
	
	//SensorBasura
	public final static String SENSORBASURA_NUEVO = "/sensor_basura/nuevo";
	public final static String SENSORBASURA_INDEX = "/sensor_basura/index";
	public final static String SENSORBASURA_UPDATE = "/sensor_basura/update";
	public static final String SENSORBASURA_EVENTOS = "/sensor_basura/eventos";
	
	/**** Redirects ****/
	public final static String ROUTE = "/user/user_select";
	public final static String SENSORBASURA_ROOT ="/sensor_basura";
	public static final String EVENTOS_ROOT = "/eventos";
	
	
}
