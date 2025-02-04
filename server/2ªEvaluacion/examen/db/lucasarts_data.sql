use lucasarts;

-- Eliminar los datos de las tablas
DELETE FROM games_characters;
DELETE FROM games;
DELETE FROM characters;
DELETE FROM directors;

-- Reiniciar los índices de las tablas (auto_increment)
ALTER TABLE games AUTO_INCREMENT = 1;
ALTER TABLE characters AUTO_INCREMENT = 1;
ALTER TABLE directors AUTO_INCREMENT = 1;
ALTER TABLE games_characters AUTO_INCREMENT = 1;


INSERT INTO `characters` (name,`role`,description) VALUES
	 ('Guybrush Threepwood','Personaje principal','Un joven aventurero que quiere convertirse en pirata.'),
	 ('Elaine Marley','Personaje principal','La gobernadora de Isla Mêlée y el interés amoroso de Guybrush.'),
	 ('LeChuck','Antagonista','Un temible pirata zombi, obsesionado con Elaine y con derrotar a Guybrush.'),
	 ('Indiana Jones','Personaje principal','Arqueólogo aventurero famoso por su látigo y su sombrero, siempre en busca de artefactos antiguos.'),
	 ('Henry Jones Sr.','Personaje principal','Padre de Indiana Jones, su conocimiento del Santo Grial es crucial para la aventura.'),
	 ('Bernard Bernoulli','Personaje principal','Un nerd con buenas intenciones, protagonista de Day of the Tentacle.'),
	 ('Dr. Fred Edison','Antagonista','El científico loco propietario de la mansión en Maniac Mansion y Day of the Tentacle.'),
	 ('Razor','Personaje principal','Una de las estudiantes atrapadas en Maniac Mansion, amante de la música punk.'),
	 ('Purple Tentacle','Antagonista','Un tentáculo mutado con ambiciones de dominar el mundo, antagonista en Day of the Tentacle.'),
	 ('Bobbin Threadbare','Personaje principal','El joven tejedor protagonista en Loom, explorando un mundo tejido por los hilos del tiempo.');
INSERT INTO `characters` (name,`role`,description) VALUES
	 ('Sam','Personaje principal','El canino detective de Sam & Max, conocido por su humor seco y sombrero de detective.'),
	 ('Max','Personaje principal','El hiperactivo conejo y compañero de Sam en Sam & Max.'),
	 ('Manny Calavera','Personaje principal','El agente de viajes del Departamento de Muerte en Grim Fandango, buscando redención.');


INSERT INTO directors (name,biography) VALUES
	 ('Ron Gilbert','Un desarrollador de videojuegos estadounidense, conocido por su trabajo en juegos de aventura como The Secret of Monkey Island y Monkey Island 2: LeChuck’s Revenge.'),
	 ('Tim Schafer','Famoso diseñador de juegos, conocido por su trabajo en LucasArts y posteriormente en su propia compañía, Double Fine Productions, involucrado en proyectos como Grim Fandango y Day of the Tentacle.'),
	 ('Hal Barwood','Un diseñador de juegos que trabajó con LucasArts; conocido especialmente por su trabajo en Indiana Jones and the Fate of Atlantis.'),
	 ('Noah Falstein','Un veterano diseñador de juegos conocido por su trabajo en varios títulos de LucasArts, incluyendo Indiana Jones and the Last Crusade.'),
	 ('Brian Moriarty','Un diseñador de juegos conocido por su trabajo en Loom, uno de los títulos clásicos de aventura de LucasArts.'),
	 ('Steve Purcell','El creador de Sam & Max, que además es escritor y artista, conocido por sus cómics y por el desarrollo del juego Sam & Max Hit the Road.');

INSERT INTO games (game_code,title,release_year,description,director_id) VALUES
	 ('MI1-1990','The Secret of Monkey Island',1990,'Un joven aspirante a pirata, Guybrush Threepwood, intenta convertirse en un pirata durante su aventura en el Caribe.',1),
	 ('MI2-1991','Monkey Island 2: LeChuck''s Revenge',1991,'Guybrush Threepwood vuelve a buscar el tesoro de Big Whoop y se enfrenta una vez más al pirata zombi LeChuck.',1),
	 ('IJ-FOA-1992','Indiana Jones and the Fate of Atlantis',1992,'Indiana Jones busca la mítica ciudad perdida de Atlantis en una aventura que se extiende por todo el mundo.',3),
	 ('IJ-LC-1989','Indiana Jones and the Last Crusade',1989,'Indiana Jones intenta encontrar el Santo Grial antes de que caiga en manos de los Nazis, siguiendo pistas que su padre dejó atrás.',4),
	 ('MM-1987','Maniac Mansion',1987,'Juego que revolucionó el género de aventuras gráficas con su sistema de comandos verbales y múltiples personajes jugables.',1),
	 ('DTT-1993','Day of the Tentacle',1993,'Secuela de Maniac Mansion que sigue las aventuras de Bernard y sus amigos intentando detener a un tentáculo púrpura que quiere conquistar el mundo.',2),
	 ('LOOM-1990','Loom',1990,'Una aventura gráfica que sigue a Bobbin Threadbare en su viaje a través de un mundo fantástico basado en la música y tejidos.',5),
	 ('SAMMAX-1993','Sam & Max Hit the Road',1993,'Sigue a los detectives freelance Sam y Max en un viaje a través de América para resolver un misterio.',6),
	 ('GRIM-1998','Grim Fandango',1998,'Una historia de aventura en el inframundo, con Manny Calavera como agente de viajes que intenta salvar almas.',2);

INSERT INTO games_characters (game_id,character_id) VALUES
	 (1,1),
	 (1,2),
	 (1,3),
	 (2,1),
	 (2,2),
	 (2,3),
	 (3,4),
	 (3,5),
	 (4,4),
	 (4,5);
INSERT INTO games_characters (game_id,character_id) VALUES
	 (5,6),
	 (5,7),
	 (6,6),
	 (6,8),
	 (6,9),
	 (7,10),
	 (8,11),
	 (8,12),
	 (9,13);

