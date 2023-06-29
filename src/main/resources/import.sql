
/*Dispositivo de Temperatura*/

INSERT dispositivo (id,nombre, activo) VALUES (1,'SensorT Lobby', b'1');
INSERT INTO sensor_temperatura (id, temperatura, aire,calefaccion ) VALUES (1, 34.5, b'1', b'0');
INSERT dispositivo (id,nombre, activo) VALUES (2,'SensorT Comedor', b'1');
INSERT INTO sensor_temperatura (id, temperatura, aire,calefaccion ) VALUES (2, 15.2, b'0',b'1');

/* Insertando eventos simulados para sensor temperatura*/

INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar aire", "2023-6-20 09:05",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar calefaccion", "2023-6-20 09:05",2);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender calefaccion", "2023-6-21 08:55",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender aire", "2023-6-21 09:05",2);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar calefaccion", "2023-6-21 10:27",1);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar aire", "2023-6-21 19:15",2);



