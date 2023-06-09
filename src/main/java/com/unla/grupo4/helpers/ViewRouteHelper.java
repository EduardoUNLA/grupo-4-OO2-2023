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
		public static final String EVENTO_FILTRO = "eventos/filtro";
		//SensorBasura
		public final static String SENSORBASURA_NUEVO = "/sensor_basura/nuevo";
		public final static String SENSORBASURA_INDEX = "/sensor_basura/index";
		public final static String SENSORBASURA_UPDATE = "/sensor_basura/update";
		public static final String SENSORBASURA_EVENTOS = "/sensor_basura/eventos";
	
	//
	public final static String SENSORLUCES_NUEVO = "/sensor_luces/nuevo";
	public final static String SENSORLUCES_INDEX = "/sensor_luces/index";
	public final static String SENSORLUCES_UPDATE = "sensor_luces/update";
	
	public final static String ALTA_SENSOR_TEMP_FORM = "/sensor_temperatura/altaSensorT";
	public final static String ALTA_EVENTO_TEMP_FORM ="/sensor_temperatura/altaEventoT";
	public final static String NVO_SENSOR_TEMP = "/sensor_temperatura/nuevo";
	public final static String NVO_EVENTO_TEMP = "/sensor_temperatura/indexE";
	public final static String SENSOR_TEMP_INDEX ="/sensor_temperatura/indexVieja";
	
	/**** Redirects ****/
	public final static String ROUTE = "/user/user_select";
	public final static String SENSORBASURA_ROOT ="/sensor_basura";
	public final static String SENSORLUCES_ROOT ="/sensor_luces";
	public static final String EVENTOS_ROOT = "/eventos";
	public final static String SENSORTEMP_ROOT ="/sensor_temperatura";
}
