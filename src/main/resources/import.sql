
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

/*Dispositivo de luces*/

INSERT dispositivo (id,nombre, activo) VALUES (3,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (3, 40, b'1', b'1', 1);
INSERT dispositivo (id,nombre, activo) VALUES (4,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (4, 15.2, b'0',b'0', 2);
INSERT dispositivo (id,nombre, activo) VALUES (5,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (5, 80.1, b'1',b'0', 3);
INSERT dispositivo (id,nombre, activo) VALUES (6,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (6, 0.7, b'1',b'1', 4);
INSERT dispositivo (id,nombre, activo) VALUES (7,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (7, 95, b'0',b'1', 5);
INSERT dispositivo (id,nombre, activo) VALUES (8,'Sensor de luces', b'1');
INSERT INTO sensor_luces (id, nivel_Luz, gente, encendido, pasillo) VALUES (8, 52.3, b'0',b'0', 6);

/* Insertando eventos simulados para sensor luces*/

INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-20 09:05",3);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar luz", "2023-6-20 09:05",4);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-21 08:55",4);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-21 09:05",5);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar luz", "2023-6-21 10:27",6);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-21 19:15",7);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-21 19:15",8);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Apagar luz", "2023-6-21 20:20",6);
INSERT INTO evento(descripcion, fechahora,dispositivo_id) VALUES ("Encender luz", "2023-6-21 20:20",5);
