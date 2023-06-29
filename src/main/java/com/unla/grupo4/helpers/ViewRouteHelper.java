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
	public final static String SENSORBASURA_UPDATE = "sensor_basura/update";
	
	//
	public final static String SENSORLUCES_NUEVO = "/sensor_luces/nuevo";
	public final static String SENSORLUCES_INDEX = "/sensor_luces/index";
	public final static String SENSORLUCES_UPDATE = "sensor_luces/update";
	
	
	/**** Redirects ****/
	public final static String ROUTE = "/user/user_select";
	public final static String SENSORBASURA_ROOT ="/sensor_basura";
	public final static String SENSORLUCES_ROOT ="/sensor_luces";
	public static final String EVENTOS_ROOT = "/eventos";
}
