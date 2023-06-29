
/*Dispositivo de Temperatura*/

INSERT dispositivo (id,nombre, activo) VALUES (1,'SensorT Lobby', b'1');
INSERT INTO sensor_temperatura (id, temperatura, aire,calefaccion ) VALUES (1, 34.5, b'1', b'0');
INSERT dispositivo (id,nombre, activo) VALUES (2,'SensorT Comedor', b'1');
INSERT INTO sensor_temperatura (id, temperatura, aire,calefaccion ) VALUES (2, 15.2, b'0',b'1');

/*Dispositivo de Temperatura*/
INSERT dispositivo (id,nombre,activo) VALUES(3,'Sensor Basura',b'1');
INSERT INTO sensor_basura (id, lleno, nro_departamento,distancia_basura ) VALUES (3,b'0',1,0.5);
INSERT dispositivo (id,nombre,activo) VALUES(4,'Sensor Basura',b'1');
INSERT INTO sensor_basura (id, lleno, nro_departamento,distancia_basura ) VALUES (4,b'0',2,0.2);
INSERT dispositivo (id,nombre,activo) VALUES(5,'Sensor Basura',b'1');
INSERT INTO sensor_basura (id, lleno, nro_departamento,distancia_basura ) VALUES (5,b'1',3,0.02);
INSERT dispositivo (id,nombre,activo) VALUES(6,'Sensor Basura',b'0');
INSERT INTO sensor_basura (id, lleno, nro_departamento,distancia_basura ) VALUES (6,b'0',4,0.6);

/* Insertando eventos simulados para sensor temperatura*/

INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar aire", "2023-6-20 09:05",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar calefaccion", "2023-6-20 09:05",2);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender calefaccion", "2023-6-21 08:55",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender aire", "2023-6-21 09:05",2);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar calefaccion", "2023-6-21 10:27",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar aire", "2023-6-21 19:15",2);

/* Insertando eventos simulados para sensor temperatura*/
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Tacho lleno, vaciar", "2023-6-20 09:05",3);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Tacho lleno, vaciar", "2023-6-20 09:05",3);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Tacho vaciado", "2023-6-20 09:05",4);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Tacho lleno, vaciar", "2023-6-20 18:05",5);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Tacho vaciado", "2023-6-20 09:05",6);



