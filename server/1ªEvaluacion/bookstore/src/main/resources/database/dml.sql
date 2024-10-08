USE bookstore;

-- Clear data from all tables and reset auto-increment IDs
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE orders_details;
TRUNCATE TABLE orders;
TRUNCATE TABLE reviews;
TRUNCATE TABLE books_authors;
TRUNCATE TABLE authors;
TRUNCATE TABLE books_genres;
TRUNCATE TABLE books;
TRUNCATE TABLE publishers;
TRUNCATE TABLE categories;
TRUNCATE TABLE genres;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO genres (name_es, name_en, slug) VALUES
    ('Infantil', 'Children\'s', 'childrens'),
    ('Juvenil', 'Young adult', 'young-adult'),
    ('Ficción', 'Fiction', 'fiction'),
    ('Fantasía', 'Fantasy', 'fantasy'),
    ('Ciencia ficción', 'Science Fiction', 'science-fiction'),
    ('Romance', 'Romance', 'romance');
    
INSERT INTO categories (name_es, name_en, slug) VALUES
    ('Novedades', 'New Releases', 'new-releases'),
    ('Recomendados', 'Recommended', 'recommended'),
    ('Más leídos', 'Best Sellers', 'best-sellers'),
    ('Ofertas', 'Offers', 'offers');
    
INSERT INTO publishers (name, slug) VALUES
    ('Editorial Sudamericana', 'editorial-sudamericana'),
    ('Anagrama', 'anagrama'),
    ('Penguin Random House', 'penguin-random-house'),
    ('HarperCollins', 'harpercollins'),
    ('Alfaguara', 'alfaguara'),
    ('Planeta', 'planeta'),
    ('Roca Editorial', 'roca-editorial'),
    ('Santillana', 'santillana'),
    ('Bloomsbury', 'bloomsbury'),
    ('Vintage Books', 'vintage-books');
    
INSERT INTO bookstore.books (isbn,title_es,title_en,synopsis_es,synopsis_en,price,discount,cover,publisher_id,category_id) VALUES
	 ('9780142424179','El principito','The Little Prince','El principito es una novela corta y la obra más famosa del escritor y aviador francés Antoine de Saint-Exupéry. La historia es filosófica y se trata de un joven príncipe que viaja de planeta en planeta, conociendo personajes que muestran distintas facetas de la naturaleza humana. En su viaje, el principito aprende sobre la soledad, el amor, la pérdida y la amistad.','The Little Prince is a novella and the most famous work of the French writer and aviator Antoine de Saint-Exupéry. The story is philosophical and involves a young prince who travels from planet to planet, meeting characters who show different aspects of human nature. In his journey, the little prince learns about loneliness, love, loss, and friendship.',15.99,10.00,'http://images.cesguiro.es/books/9780142424179.webp',1,1),
	 ('9780142410363','Matilda','Matilda','Matilda es una niña prodigio con unos padres terriblemente negligentes. A pesar de su ambiente familiar hostil, Matilda descubre su amor por la lectura y su capacidad telequinética. Cuando comienza la escuela, se encuentra con la terrible directora, la señorita Trunchbull, pero también con la amable señorita Honey. Con el tiempo, Matilda usa sus poderes para enfrentarse a las injusticias de los adultos en su vida.','Matilda is a prodigy child with terribly negligent parents. Despite her hostile family environment, Matilda discovers her love for reading and her telekinetic ability. When she starts school, she encounters the terrible headmistress Miss Trunchbull, but also the kind Miss Honey. Over time, Matilda uses her powers to fight against the injustices of the adults in her life.',14.99,5.00,'http://images.cesguiro.es/books/9780142410363.webp',2,2),
	 ('9780142418222','Charlie y la fábrica de chocolate','Charlie and the Chocolate Factory','Charlie Bucket es un niño pobre que vive con su familia cerca de la gigantesca fábrica de chocolate de Willy Wonka. Un día, Willy Wonka decide abrir las puertas de su fábrica a cinco niños afortunados que encuentren un billete dorado dentro de las chocolatinas Wonka. Charlie, contra todo pronóstico, encuentra uno de los billetes y su vida cambia para siempre al descubrir los secretos y maravillas de la fábrica de chocolate.','Charlie Bucket is a poor boy living with his family near Willy Wonka''s gigantic chocolate factory. One day, Willy Wonka decides to open the doors of his factory to five lucky children who find a golden ticket inside Wonka chocolate bars. Charlie, against all odds, finds one of the tickets, and his life changes forever as he discovers the secrets and wonders of the chocolate factory.',13.99,15.00,'http://images.cesguiro.es/books/9780142418222.jpeg',2,4),
	 ('9780060256654','Donde viven los monstruos','Where the Wild Things Are','Donde viven los monstruos es un cuento infantil escrito e ilustrado por Maurice Sendak. El libro describe la historia de Max, un niño travieso que se embarca en una aventura a un mundo de monstruos salvajes después de ser enviado a la cama sin cenar. En este mundo imaginario, Max se convierte en el rey de los monstruos pero pronto se da cuenta de que extraña a su familia y decide regresar a casa.','Where the Wild Things Are is a children''s book written and illustrated by Maurice Sendak. The book tells the story of Max, a mischievous boy who embarks on an adventure to a world of wild monsters after being sent to bed without dinner. In this imaginary world, Max becomes the king of the monsters but soon realizes he misses his family and decides to return home.',16.99,15.00,'http://images.cesguiro.es/books/9780060256654.webp',3,4),
	 ('9780618260300','El león, la bruja y el armario','The Lion, the Witch and the Wardrobe','El león, la bruja y el ropero es una novela de fantasía infantil escrita por C.S. Lewis. Es el primer libro publicado y el segundo en la cronología interna de la serie Las crónicas de Narnia. La historia sigue a cuatro niños que descubren el mundo mágico de Narnia a través de un ropero y se unen al león Aslan para derrotar a la malvada Bruja Blanca.','The Lion, the Witch and the Wardrobe is a children''s fantasy novel by C.S. Lewis. It is the first book published and the second in the chronological order of the series The Chronicles of Narnia. The story follows four children who discover the magical world of Narnia through a wardrobe and join the lion Aslan to defeat the evil White Witch.',18.99,0.00,'http://images.cesguiro.es/books/9780618260300.webp',3,3),
	 ('9780439554930','Harry Potter y la piedra filosofal','Harry Potter and the Sorcerer''s Stone','Harry Potter es un niño huérfano que vive con sus abusivos tíos. En su undécimo cumpleaños, descubre que es un mago y es invitado a asistir al Colegio Hogwarts de Magia y Hechicería. Allí, Harry hace amigos y enemigos y descubre la verdad sobre sus padres y su conexión con el mago oscuro Voldemort.','Harry Potter is an orphaned boy living with his abusive aunt and uncle. On his eleventh birthday, he discovers he is a wizard and is invited to attend the Hogwarts School of Witchcraft and Wizardry. There, Harry makes friends and enemies and learns the truth about his parents and his connection to the dark wizard Voldemort.',19.99,15.00,'http://images.cesguiro.es/books/9780439554930.webp',4,4),
	 ('9781451673319','El cuento de Ferdinando','The Story of Ferdinand','El cuento de Ferdinando es una historia infantil escrita por Munro Leaf e ilustrada por Robert Lawson. El libro cuenta la historia de un toro pacífico llamado Ferdinando que prefiere oler flores en lugar de luchar. Cuando es picado por una abeja, su comportamiento cambia y es llevado a una corrida de toros, pero finalmente regresa a su vida tranquila en el campo.','The Story of Ferdinand is a children''s book written by Munro Leaf and illustrated by Robert Lawson. The book tells the story of a peaceful bull named Ferdinand who prefers to smell flowers rather than fight. When he is stung by a bee, his behavior changes and he is taken to a bullfight, but he eventually returns to his quiet life in the countryside.',12.99,5.00,'http://images.cesguiro.es/books/9781451673319.jpg',5,1),
	 ('9780064400558','Alicia en el país de las maravillas','Alice''s Adventures in Wonderland','Alicia en el país de las maravillas es una novela escrita por Lewis Carroll. La historia sigue a una joven llamada Alicia que cae por una madriguera de conejo y entra en un mundo fantástico lleno de criaturas peculiares y situaciones absurdas. A lo largo de su aventura, Alicia debe navegar por este mundo extraño y surrealista mientras trata de encontrar su camino de regreso a casa.','Alice''s Adventures in Wonderland is a novel written by Lewis Carroll. The story follows a young girl named Alice who falls down a rabbit hole and enters a fantastical world filled with peculiar creatures and absurd situations. Throughout her adventure, Alice must navigate this strange and surreal world as she tries to find her way back home.',11.99,0.00,'http://images.cesguiro.es/books/9780064400558.webp',5,2),
	 ('9780439023528','Los juegos del hambre','The Hunger Games','En un futuro distópico, la joven Katniss Everdeen debe participar en Los Juegos del Hambre, un evento televisado en el que 24 adolescentes luchan a muerte hasta que solo uno quede con vida. Katniss se ofrece como voluntaria para salvar a su hermana menor y deberá usar todas sus habilidades para sobrevivir.','In a dystopian future, young Katniss Everdeen must participate in The Hunger Games, a televised event where 24 teenagers fight to the death until only one remains. Katniss volunteers to save her younger sister and must use all her skills to survive.',19.99,0.00,'http://images.cesguiro.es/books/9780439023528.webp',3,3),
	 ('9781423103349','Percy Jackson y el ladrón del rayo','Percy Jackson and the Olympians: The Lightning Thief','Percy Jackson descubre que es un semidiós, hijo de Poseidón, y se embarca en una aventura para evitar una guerra entre los dioses del Olimpo. Junto con sus amigos, Percy debe recuperar el rayo robado de Zeus antes de que sea demasiado tarde.','Percy Jackson discovers that he is a demigod, the son of Poseidon, and embarks on an adventure to prevent a war among the gods of Olympus. Along with his friends, Percy must retrieve Zeus'' stolen lightning bolt before it''s too late.',17.99,0.00,'http://images.cesguiro.es/books/9781423103349.webp',4,1);

INSERT INTO bookstore.books (isbn,title_es,title_en,synopsis_es,synopsis_en,price,discount,cover,publisher_id,category_id) VALUES
	 ('9780316015844','Crepúsculo','Twilight','Bella Swan se muda a la lluviosa ciudad de Forks y se enamora de Edward Cullen, un misterioso joven que resulta ser un vampiro. A medida que su relación se profundiza, Bella se ve envuelta en el peligroso mundo de los vampiros y debe enfrentarse a las amenazas que se ciernen sobre ellos.','Bella Swan moves to the rainy town of Forks and falls in love with Edward Cullen, a mysterious young man who turns out to be a vampire. As their relationship deepens, Bella becomes entangled in the dangerous world of vampires and must face the threats that loom over them.',15.99,0.00,'http://images.cesguiro.es/books/9780316015844.webp',2,2),
	 ('9780062024039','Divergente','Divergent','En una sociedad dividida en facciones basadas en virtudes humanas, Beatrice Prior descubre que es una Divergente, alguien que no encaja en ninguna facción. Cuando descubre una conspiración para destruir a los Divergentes, Beatrice debe encontrar su lugar y proteger a aquellos que ama.','In a society divided into factions based on human virtues, Beatrice Prior discovers that she is Divergent, someone who does not fit into any faction. When she uncovers a conspiracy to destroy Divergents, Beatrice must find her place and protect those she loves.',18.99,10.00,'http://images.cesguiro.es/books/9780062024039.webp',5,3),
	 ('9781416914280','Cazadores de sombras: Ciudad de hueso','The Mortal Instruments: City of Bones','Clary Fray descubre que pertenece a una raza de guerreros mitad ángeles llamados cazadores de sombras, cuya misión es proteger el mundo de los demonios. Junto a otros cazadores de sombras, Clary debe desentrañar el misterio de su pasado y luchar contra las fuerzas oscuras que amenazan su mundo.','Clary Fray discovers that she belongs to a race of half-angel warriors called Shadowhunters, whose mission is to protect the world from demons. Alongside other Shadowhunters, Clary must unravel the mystery of her past and fight against the dark forces that threaten her world.',17.99,15.00,'http://images.cesguiro.es/books/9781416914280.webp',1,4),
	 ('9780385737951','El corredor del laberinto','The Maze Runner','Thomas despierta en un ascensor oscuro y ascendente, sin recordar nada excepto su nombre. Cuando las puertas se abren, se encuentra rodeado de otros chicos en un laberinto gigantesco y mortal. Thomas debe unir fuerzas con los demás para escapar y descubrir la verdad detrás del laberinto.','Thomas wakes up in a dark, ascending elevator with no memory except his name. When the doors open, he finds himself surrounded by other boys in a massive, deadly maze. Thomas must join forces with the others to escape and uncover the truth behind the maze.',16.99,15.00,'http://images.cesguiro.es/books/9780385737951.webp',3,4),
	 ('9781250047819','Eleanor & Park','Eleanor & Park','Eleanor y Park son dos adolescentes inadaptados que se encuentran en el autobús escolar y forman una conexión inesperada a través de su amor por la música y los cómics. A medida que su relación crece, deben enfrentarse a los desafíos y prejuicios de la vida en su pequeño pueblo.','Eleanor and Park are two misfit teenagers who meet on the school bus and form an unexpected connection through their love of music and comics. As their relationship grows, they must face the challenges and prejudices of life in their small town.',14.99,5.00,'http://images.cesguiro.es/books/9781250047819.webp',4,1),
	 ('9780142424180','Bajo la misma estrella','The Fault in Our Stars','Hazel Grace Lancaster es una adolescente con cáncer terminal que se enamora de Augustus Waters, un joven que asiste a su grupo de apoyo para pacientes con cáncer. Juntos, emprenden un viaje de amor y valentía mientras enfrentan la realidad de su enfermedad.','Hazel Grace Lancaster is a teenager with terminal cancer who falls in love with Augustus Waters, a young man who attends her cancer patient support group. Together, they embark on a journey of love and bravery as they face the reality of their illness.',15.99,15.00,'http://images.cesguiro.es/books/9780142424180.webp',2,4),
	 ('9780618260400','El hobbit','The Hobbit','El hobbit cuenta la historia de Bilbo Bolsón, un hobbit que se embarca en una aventura inesperada para ayudar a un grupo de enanos a recuperar su montaña y su tesoro del dragón Smaug.','The Hobbit tells the story of Bilbo Baggins, a hobbit who embarks on an unexpected adventure to help a group of dwarves reclaim their mountain and treasure from the dragon Smaug.',14.99,0.00,'http://images.cesguiro.es/books/9780618260400.jpg',3,2),
	 ('9780261103573','El señor de los anillos: La comunidad del anillo','The Lord of the Rings: The Fellowship of the Ring','La comunidad del anillo sigue a Frodo Bolsón y sus compañeros en su misión de destruir el Anillo Único, una poderosa reliquia creada por el señor oscuro Sauron.','The Fellowship of the Ring follows Frodo Baggins and his companions on their mission to destroy the One Ring, a powerful relic created by the dark lord Sauron.',19.99,0.00,'http://images.cesguiro.es/books/9780261103573.webp',3,3),
	 ('9780261102361','El señor de los anillos: Las dos torres','The Lord of the Rings: The Two Towers','Las dos torres continúa la misión de Frodo y Sam para destruir el Anillo Único, mientras Aragorn, Legolas y Gimli buscan a Merry y Pippin, que han sido capturados por orcos.','The Two Towers continues Frodo and Sam''s mission to destroy the One Ring, while Aragorn, Legolas, and Gimli search for Merry and Pippin, who have been captured by orcs.',19.99,0.00,'http://images.cesguiro.es/books/9780261102361.webp',3,1),
	 ('9780316029186','El último deseo','The Last Wish','El último deseo es una colección de relatos que presenta al brujo Geralt de Rivia, un cazador de monstruos en un mundo de fantasía lleno de criaturas peligrosas y magia.','The Last Wish is a collection of stories introducing the witcher Geralt of Rivia, a monster hunter in a fantasy world full of dangerous creatures and magic.',18.99,10.00,'http://images.cesguiro.es/books/9780316029186.jpg',4,2);
	 
INSERT INTO bookstore.books (isbn,title_es,title_en,synopsis_es,synopsis_en,price,discount,cover,publisher_id,category_id) VALUES
	 ('9780316073797','La espada del destino','Sword of Destiny','La espada del destino es una colección de relatos que sigue las aventuras de Geralt de Rivia mientras enfrenta a monstruos y se cruza con personajes importantes en su vida.','Sword of Destiny is a collection of stories following Geralt of Rivia''s adventures as he faces monsters and encounters important characters in his life.',18.99,5.00,'http://images.cesguiro.es/books/9780316073797.jpeg',4,3),
	 ('9780060557912','Buenos presagios','Good Omens','Buenos presagios cuenta la historia de un ángel y un demonio que unen fuerzas para evitar el apocalipsis. Ambos han vivido en la Tierra durante siglos y se han encariñado con la humanidad, por lo que harán todo lo posible para detener el fin del mundo.','Good Omens tells the story of an angel and a demon who team up to prevent the apocalypse. Both have lived on Earth for centuries and have grown fond of humanity, so they will do everything possible to stop the end of the world.',16.99,0.00,'http://images.cesguiro.es/books/9780060557912.jpg',5,2),
	 ('9780060853983','American Gods','American Gods','American Gods sigue a Shadow Moon, un exconvicto que se convierte en guardaespaldas del enigmático Sr. Wednesday. Pronto descubre que su jefe es una encarnación de Odín, y se ve envuelto en una batalla entre los antiguos dioses y los nuevos.','American Gods follows Shadow Moon, an ex-convict who becomes the bodyguard of the enigmatic Mr. Wednesday. He soon discovers that his boss is an incarnation of Odin, and he becomes embroiled in a battle between the old gods and the new.',17.99,15.00,'http://images.cesguiro.es/books/9780060853983.webp',5,4),
	 ('9780060557812','Stardust','Stardust','Stardust narra la aventura de Tristran Thorn, quien promete traerle a su amada una estrella caída. Su búsqueda lo lleva al reino mágico de Faerie, donde descubre que la estrella es una mujer y se enfrenta a peligros inesperados.','Stardust tells the adventure of Tristran Thorn, who promises to bring his beloved a fallen star. His quest leads him to the magical realm of Faerie, where he discovers that the star is a woman and faces unexpected dangers.',15.99,5.00,'http://images.cesguiro.es/books/9780060557812.webp',5,2);

INSERT INTO authors (name, nationality, biography_en, biography_es, birth_year, death_year) VALUES
    ('Antoine de Saint-Exupéry', 'French', 'Antoine de Saint-Exupéry was a French writer, poet, aristocrat, journalist, and pioneering aviator. He is best remembered for his novella The Little Prince and for his lyrical aviation writings.', 'Antoine de Saint-Exupéry fue un escritor, poeta, aristócrata, periodista y aviador pionero francés. Es recordado por su novela corta El principito y por sus escritos líricos sobre la aviación.', 1900, 1944),
    ('Roald Dahl', 'British', 'Roald Dahl was a British novelist, short-story writer, poet, screenwriter, and wartime fighter pilot. His books have sold more than 250 million copies worldwide.', 'Roald Dahl fue un novelista, cuentista, poeta, guionista y piloto de combate británico. Sus libros han vendido más de 250 millones de copias en todo el mundo.', 1916, 1990),
    ('Maurice Sendak', 'American', 'Maurice Sendak was an American illustrator and writer of children''s books. He became widely known for his book Where the Wild Things Are.', 'Maurice Sendak fue un ilustrador y escritor estadounidense de libros infantiles. Se hizo conocido mundialmente por su libro Donde viven los monstruos.', 1928, 2012),
    ('C.S. Lewis', 'British', 'C.S. Lewis was a British writer and lay theologian. He is best known for his works of fiction, especially The Chronicles of Narnia.', 'C.S. Lewis fue un escritor y teólogo laico británico. Es conocido por sus obras de ficción, especialmente Las crónicas de Narnia.', 1898, 1963),
    ('J.K. Rowling', 'British', 'J.K. Rowling is a British author, best known for the Harry Potter series.', 'J.K. Rowling es una autora británica, conocida por la serie Harry Potter.', 1965, NULL),
    ('Munro Leaf', 'American', 'Munro Leaf was an American author of children''s literature who wrote The Story of Ferdinand.', 'Munro Leaf fue un autor estadounidense de literatura infantil que escribió El cuento de Ferdinando.', 1905, 1976),
    ('Lewis Carroll', 'British', 'Lewis Carroll was an English writer, mathematician, logician, Anglican deacon, and photographer. He is best known for his fantasy works Alice''s Adventures in Wonderland and its sequel Through the Looking-Glass.', 'Lewis Carroll fue un escritor, matemático, lógico, diácono anglicano y fotógrafo inglés. Es conocido por sus obras de fantasía Alicia en el país de las maravillas y su secuela A través del espejo.', 1832, 1898),
    ('Suzanne Collins', 'American', 'Suzanne Collins is an American television writer and author, best known for The Hunger Games series.', 'Suzanne Collins es una guionista y autora estadounidense, conocida por la serie Los Juegos del Hambre.', 1962, NULL),
    ('Rick Riordan', 'American', 'Rick Riordan is an American author, best known for writing the Percy Jackson & the Olympians series.', 'Rick Riordan es un autor estadounidense, conocido por escribir la serie Percy Jackson y los dioses del Olimpo.', 1964, NULL),
    ('Stephenie Meyer', 'American', 'Stephenie Meyer is an American novelist and film producer, best known for her vampire romance series Twilight.', 'Stephenie Meyer es una novelista y productora de cine estadounidense, conocida por su serie de romance vampírico Crepúsculo.', 1973, NULL),
    ('Veronica Roth', 'American', 'Veronica Roth is an American novelist and short story writer, known for her debut New York Times bestselling Divergent trilogy.', 'Veronica Roth es una novelista y escritora de cuentos estadounidense, conocida por su trilogía debut Divergente, que fue un éxito de ventas en el New York Times.', 1988, NULL),
    ('Cassandra Clare', 'American', 'Cassandra Clare is an American author of young adult fiction, best known for her series The Mortal Instruments.', 'Cassandra Clare es una autora estadounidense de ficción juvenil, conocida por su serie Cazadores de sombras.', 1973, NULL),
    ('James Dashner', 'American', 'James Dashner is an American author of speculative fiction, primarily series for children or young adults, such as The Maze Runner.', 'James Dashner es un autor estadounidense de ficción especulativa, principalmente series para niños o jóvenes, como El corredor del laberinto.', 1972, NULL),
    ('Rainbow Rowell', 'American', 'Rainbow Rowell is an American author known for young adult and adult contemporary novels, including Eleanor & Park.', 'Rainbow Rowell es una autora estadounidense conocida por sus novelas contemporáneas para jóvenes y adultos, incluyendo Eleanor & Park.', 1973, NULL),
    ('John Green', 'American', 'John Green is an American author and YouTube content creator. He is the author of Looking for Alaska and The Fault in Our Stars.', 'John Green es un autor estadounidense y creador de contenido en YouTube. Es el autor de Buscando a Alaska y Bajo la misma estrella.', 1977, NULL),
    ('Terry Pratchett', 'British', 'Terry Pratchett was an English author of fantasy novels, best known for his Discworld series.', 'Terry Pratchett fue un autor inglés de novelas de fantasía, conocido por su serie Mundodisco.', 1948, 2015),
    ('Neil Gaiman', 'British', 'Neil Gaiman is an English author of short fiction, novels, comic books, graphic novels, audio theatre, and films. His notable works include the comic book series The Sandman and novels Stardust, American Gods, and Good Omens.', 'Neil Gaiman es un autor inglés de cuentos, novelas, cómics, novelas gráficas, teatro audio y películas. Sus obras notables incluyen la serie de cómics The Sandman y las novelas Stardust, American Gods, y Good Omens.', 1960, NULL),
    ('Andrzej Sapkowski', 'Polish', 'Andrzej Sapkowski is a Polish fantasy writer, best known for his book series The Witcher.', 'Andrzej Sapkowski es un escritor de fantasía polaco, conocido por su serie de libros The Witcher.', 1948, NULL),
    ('J.R.R. Tolkien', 'British', 'J.R.R. Tolkien was an English writer, poet, philologist, and academic, best known for The Lord of the Rings.', 'J.R.R. Tolkien fue un escritor, poeta, filólogo y académico inglés, conocido por El señor de los anillos.', 1892, 1973);

INSERT INTO books_authors (book_id, author_id) VALUES
    (1, 1),  -- El principito by Antoine de Saint-Exupéry
    (2, 2),  -- Matilda by Roald Dahl
    (3, 2),  -- Charlie y la fábrica de chocolate by Roald Dahl
    (4, 3),  -- Donde viven los monstruos by Maurice Sendak
    (5, 4),  -- El león, la bruja y el ropero by C.S. Lewis
    (6, 5),  -- Harry Potter y la piedra filosofal by J.K. Rowling
    (7, 6),  -- El cuento de Ferdinando by Munro Leaf
    (8, 7),  -- Alicia en el país de las maravillas by Lewis Carroll
    (9, 8),   -- Los juegos del hambre by Suzanne Collins
    (10, 9),  -- Percy Jackson y el ladrón del rayo by Rick Riordan
    (11, 10), -- Crepúsculo by Stephenie Meyer
    (12, 11), -- Divergente by Veronica Roth
    (13, 12), -- Cazadores de sombras: Ciudad de hueso by Cassandra Clare
    (14, 13), -- El corredor del laberinto by James Dashner
    (15, 14), -- Eleanor & Park by Rainbow Rowell
    (16, 15), -- Bajo la misma estrella by John Green
    (17, 19),  -- El hobbit by J.R.R. Tolkien
    (18, 19),  -- El señor de los anillos: La comunidad del anillo by J.R.R. Tolkien
    (19, 19),  -- El señor de los anillos: Las dos torres by J.R.R. Tolkien
    (20, 18),  -- El último deseo by Andrzej Sapkowski
    (21, 18),  -- La espada del destino by Andrzej Sapkowski
    (22, 16),  -- Buenos presagios by Neil Gaiman
    (22, 17),  -- Buenos presagios by Terry Pratchett
    (23, 17),  -- American Gods by Neil Gaiman
    (24, 17);  -- Stardust by Neil Gaiman    
    
INSERT INTO books_genres (book_id, genre_id) VALUES
    (1, 1), -- El principito (Infantil)
    (2, 1), -- Matilda (Infantil)
    (3, 1), -- Charlie y la fábrica de chocolate (Infantil)
    (4, 1), -- Donde viven los monstruos (Infantil)
    (5, 1), -- El león, la bruja y el ropero (Infantil)
    (6, 1), -- Harry Potter y la piedra filosofal (Infantil)
    (7, 1), -- El cuento de Ferdinando (Infantil)
    (8, 1), -- Alicia en el país de las maravillas (Infantil)
    (9, 2),  -- Los juegos del hambre (Juvenil)
    (10, 2), -- Percy Jackson y el ladrón del rayo (Juvenil)
    (11, 2), -- Crepúsculo (Juvenil)
    (12, 2), -- Divergente (Juvenil)
    (13, 2), -- Cazadores de sombras: Ciudad de hueso (Juvenil)
    (14, 2), -- El corredor del laberinto (Juvenil)
    (15, 2), -- Eleanor & Park (Juvenil)
    (16, 2), -- Bajo la misma estrella (Juvenil)
    (1, 3),  -- El principito (Ficción)
    (5, 3),  -- El león, la bruja y el ropero (Ficción)
    (6, 3),  -- Harry Potter y la piedra filosofal (Ficción)
    (8, 3),  -- Alicia en el país de las maravillas (Ficción)    
    (17, 4),  -- El hobbit (Fantasía)
    (18, 4),  -- El señor de los anillos: La comunidad del anillo (Fantasía)
    (19, 4),  -- El señor de los anillos: Las dos torres (Fantasía)
    (20, 4),  -- El último deseo (Fantasía)
    (21, 4),  -- La espada del destino (Fantasía)
    (22, 4),  -- Buenos presagios (Fantasía)
    (23, 4),  -- American Gods (Fantasía)
    (24, 4);  -- Stardust (Fantasía)    
    
INSERT INTO users (username, password, email, first_name, last_name, address, language, is_admin) VALUES
('admin', 'admin', 'admin@example.com', 'Admin', 'User', '999 Admin Street', 'en', 1),
('user1', 'user1', 'user1@example.com', 'John', 'Doe', '123 Maple Street', 'es', 0),
('user2', 'user2', 'user2@example.com', 'Jane', 'Smith', '456 Oak Avenue', 'en', 0),
('user3', 'user3', 'user3@example.com', 'Alice', 'Johnson', '789 Pine Road', 'es', 0),
('user4', 'user4', 'user4@example.com', 'Bob', 'Brown', '321 Cedar Lane', 'en', 0),
('user5', 'user5', 'user5@example.com', 'Charlie', 'Davis', '654 Elm Street', 'es', 0),
('user6', 'user6', 'user6@example.com', 'Emily', 'Clark', '987 Birch Boulevard', 'en', 0),
('user7', 'user7', 'user7@example.com', 'Daniel', 'Miller', '123 Spruce Drive', 'es', 0),
('user8', 'user8', 'user8@example.com', 'Sophia', 'Wilson', '456 Redwood Circle', 'en', 0),
('user9', 'user9', 'user9@example.com', 'James', 'Moore', '789 Ash Terrace', 'es', 0);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (1,7,'Review for book 1 by user 7',1),
	 (1,5,'Review for book 1 by user 5',5),
	 (1,1,'Review for book 1 by user 1',4),
	 (1,1,'Review for book 1 by user 1',2),
	 (1,8,'Review for book 1 by user 8',4),
	 (2,1,'Review for book 2 by user 1',2),
	 (2,4,'Review for book 2 by user 4',5),
	 (2,3,'Review for book 2 by user 3',4),
	 (2,10,'Review for book 2 by user 10',2),
	 (2,1,'Review for book 2 by user 1',2);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (3,8,'Review for book 3 by user 8',5),
	 (3,7,'Review for book 3 by user 7',3),
	 (3,1,'Review for book 3 by user 1',2),
	 (3,8,'Review for book 3 by user 8',2),
	 (3,1,'Review for book 3 by user 1',3),
	 (3,7,'Review for book 3 by user 7',3),
	 (3,3,'Review for book 3 by user 3',1),
	 (3,6,'Review for book 3 by user 6',2),
	 (4,7,'Review for book 4 by user 7',5),
	 (4,2,'Review for book 4 by user 2',2);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (4,3,'Review for book 4 by user 3',3),
	 (4,2,'Review for book 4 by user 2',4),
	 (4,7,'Review for book 4 by user 7',3),
	 (5,6,'Review for book 5 by user 6',2),
	 (5,2,'Review for book 5 by user 2',3),
	 (5,5,'Review for book 5 by user 5',4),
	 (5,1,'Review for book 5 by user 1',1),
	 (5,8,'Review for book 5 by user 8',1),
	 (5,5,'Review for book 5 by user 5',4),
	 (6,7,'Review for book 6 by user 7',4);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (6,8,'Review for book 6 by user 8',4),
	 (6,10,'Review for book 6 by user 10',5),
	 (6,3,'Review for book 6 by user 3',5),
	 (6,10,'Review for book 6 by user 10',1),
	 (7,4,'Review for book 7 by user 4',4),
	 (7,6,'Review for book 7 by user 6',2),
	 (7,2,'Review for book 7 by user 2',4),
	 (7,2,'Review for book 7 by user 2',4),
	 (7,9,'Review for book 7 by user 9',1),
	 (8,2,'Review for book 8 by user 2',3);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (8,4,'Review for book 8 by user 4',5),
	 (8,6,'Review for book 8 by user 6',1),
	 (8,6,'Review for book 8 by user 6',5),
	 (8,5,'Review for book 8 by user 5',3),
	 (9,7,'Review for book 9 by user 7',4),
	 (9,9,'Review for book 9 by user 9',5),
	 (9,8,'Review for book 9 by user 8',2),
	 (9,3,'Review for book 9 by user 3',2),
	 (9,8,'Review for book 9 by user 8',1),
	 (9,10,'Review for book 9 by user 10',3);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (9,5,'Review for book 9 by user 5',4),
	 (10,7,'Review for book 10 by user 7',2),
	 (10,2,'Review for book 10 by user 2',5),
	 (10,4,'Review for book 10 by user 4',5),
	 (10,7,'Review for book 10 by user 7',2),
	 (10,8,'Review for book 10 by user 8',4),
	 (10,6,'Review for book 10 by user 6',2),
	 (10,10,'Review for book 10 by user 10',4),
	 (11,10,'Review for book 11 by user 10',1),
	 (11,8,'Review for book 11 by user 8',1);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (11,8,'Review for book 11 by user 8',1),
	 (11,5,'Review for book 11 by user 5',5),
	 (11,8,'Review for book 11 by user 8',1),
	 (11,9,'Review for book 11 by user 9',3),
	 (11,9,'Review for book 11 by user 9',4),
	 (11,10,'Review for book 11 by user 10',4),
	 (12,9,'Review for book 12 by user 9',2),
	 (12,5,'Review for book 12 by user 5',4),
	 (12,1,'Review for book 12 by user 1',2),
	 (12,5,'Review for book 12 by user 5',1);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (12,3,'Review for book 12 by user 3',1),
	 (13,9,'Review for book 13 by user 9',4),
	 (13,6,'Review for book 13 by user 6',1),
	 (13,7,'Review for book 13 by user 7',5),
	 (13,3,'Review for book 13 by user 3',4),
	 (13,5,'Review for book 13 by user 5',2),
	 (13,2,'Review for book 13 by user 2',4),
	 (13,4,'Review for book 13 by user 4',3),
	 (13,5,'Review for book 13 by user 5',3),
	 (13,8,'Review for book 13 by user 8',5);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (13,9,'Review for book 13 by user 9',5),
	 (14,3,'Review for book 14 by user 3',4),
	 (14,5,'Review for book 14 by user 5',3),
	 (14,7,'Review for book 14 by user 7',5),
	 (14,5,'Review for book 14 by user 5',3),
	 (14,7,'Review for book 14 by user 7',4),
	 (14,1,'Review for book 14 by user 1',3),
	 (15,5,'Review for book 15 by user 5',1),
	 (15,1,'Review for book 15 by user 1',5),
	 (15,2,'Review for book 15 by user 2',2);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (15,8,'Review for book 15 by user 8',5),
	 (15,3,'Review for book 15 by user 3',4),
	 (15,2,'Review for book 15 by user 2',1),
	 (15,5,'Review for book 15 by user 5',5),
	 (16,1,'Review for book 16 by user 1',5),
	 (16,2,'Review for book 16 by user 2',1),
	 (16,8,'Review for book 16 by user 8',4),
	 (16,6,'Review for book 16 by user 6',2),
	 (16,9,'Review for book 16 by user 9',2),
	 (16,2,'Review for book 16 by user 2',3);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (17,10,'Review for book 17 by user 10',2),
	 (17,3,'Review for book 17 by user 3',4),
	 (17,9,'Review for book 17 by user 9',1),
	 (17,7,'Review for book 17 by user 7',2),
	 (17,3,'Review for book 17 by user 3',4),
	 (17,5,'Review for book 17 by user 5',1),
	 (17,1,'Review for book 17 by user 1',2),
	 (17,2,'Review for book 17 by user 2',5),
	 (18,3,'Review for book 18 by user 3',4),
	 (18,3,'Review for book 18 by user 3',3);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (18,1,'Review for book 18 by user 1',3),
	 (18,10,'Review for book 18 by user 10',3),
	 (18,7,'Review for book 18 by user 7',4),
	 (18,8,'Review for book 18 by user 8',2),
	 (19,8,'Review for book 19 by user 8',2),
	 (19,2,'Review for book 19 by user 2',5),
	 (19,7,'Review for book 19 by user 7',5),
	 (19,3,'Review for book 19 by user 3',3),
	 (19,1,'Review for book 19 by user 1',4),
	 (19,4,'Review for book 19 by user 4',3);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (19,6,'Review for book 19 by user 6',1),
	 (19,7,'Review for book 19 by user 7',1),
	 (20,7,'Review for book 20 by user 7',3),
	 (20,8,'Review for book 20 by user 8',5),
	 (20,5,'Review for book 20 by user 5',3),
	 (20,8,'Review for book 20 by user 8',4),
	 (20,1,'Review for book 20 by user 1',1),
	 (20,2,'Review for book 20 by user 2',3),
	 (20,5,'Review for book 20 by user 5',4),
	 (20,3,'Review for book 20 by user 3',1);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (21,7,'Review for book 21 by user 7',1),
	 (21,9,'Review for book 21 by user 9',5),
	 (21,10,'Review for book 21 by user 10',5),
	 (21,5,'Review for book 21 by user 5',4),
	 (21,9,'Review for book 21 by user 9',2),
	 (21,5,'Review for book 21 by user 5',5),
	 (21,2,'Review for book 21 by user 2',1),
	 (22,3,'Review for book 22 by user 3',4),
	 (22,1,'Review for book 22 by user 1',2),
	 (22,8,'Review for book 22 by user 8',1);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (22,6,'Review for book 22 by user 6',1),
	 (22,9,'Review for book 22 by user 9',1),
	 (23,9,'Review for book 23 by user 9',2),
	 (23,3,'Review for book 23 by user 3',2),
	 (23,6,'Review for book 23 by user 6',5),
	 (23,1,'Review for book 23 by user 1',3),
	 (23,5,'Review for book 23 by user 5',5),
	 (23,8,'Review for book 23 by user 8',1),
	 (24,5,'Review for book 24 by user 5',5),
	 (24,4,'Review for book 24 by user 4',4);

INSERT INTO bookstore.reviews (book_id,user_id,review,rating) VALUES
	 (24,8,'Review for book 24 by user 8',3),
	 (24,6,'Review for book 24 by user 6',5),
	 (24,2,'Review for book 24 by user 2',5);