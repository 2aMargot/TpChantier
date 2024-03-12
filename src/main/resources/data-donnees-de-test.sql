INSERT INTO consommable(name) VALUES ("Béton"), ("Ciment"), ("Barre de fer"), ("Aglo"), ("Gravier"), ("Sable"), ("Tuiles"), ("Fenetres"), ("Portes");

INSERT INTO tache(name, temps) VALUES ("Faire un tres gros trou", "24"), ("Faire du béton", "1");

INSERT INTO role(designation) VALUES ("client"), ("administrateur"), ("ouvrier");

INSERT INTO user (pseudo, password, role_id) VALUES ("youpi", "1234",3), ("yolo", "0000",2),("blop", "789",1);

INSERT INTO chantier(name, address, user_id) VALUES ("Fondation immeuble 3 étage", "1 rue Jean Jaurés 54000 Metz", 1), ("Parking Gare 200 places", "2 place de la gare 54000 Metz", 2);

INSERT INTO operation(name, date, tache_id, chantier_id, user_id) VALUES ("Creuser les fondations",  DATE '2024-03-18', 1, 1,1), ("Couler la dalle", DATE '2024-03-25', 2, 2,2);

INSERT INTO consommable_tache (consommable_id, tache_id) VALUES (1,2), (3,2);