-- Inserción de usuarios
INSERT INTO "user" (username, email, password, rol)
VALUES
    ('john_doe', 'john.doe@example.com', 'password123', 'user'),
    ('jane_doe', 'jane.doe@example.com', 'password123', 'user'),
    ('admin', 'admin@example.com', 'adminpassword', 'admin');

-- Inserción de peleadores
INSERT INTO fighter (
    name, surname, nickname, nationality, age, weight, height, reach,
    total_fights, total_wins, wins_ko, wins_sub, wins_dec,
    total_losses, losses_ko, losses_sub, losses_dec,
    draws, ranking, image
) VALUES
      ('Islam', 'Makhachev', 'The Eagle 2.0', 'Russia', 32, 155.0, 1.78, 70.0, 26, 25, 5, 10, 10, 1, 0, 0, 1, 0, 1, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/7/MAKHACHEV_ISLAM_L_BELT_01-18.png?itok=lqIEHOin'),
      ('Jon', 'Jones', 'Bones', 'USA', 36, 205.0, 1.93, 84.5, 29, 27, 10, 6, 11, 1, 0, 0, 1, 1, 2, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/JONES_JON_L_BELT_11-16.png?itok=V9GBsbVF'),
      ('Ilia', 'Topuria', 'El Matador', 'Spain', 27, 145.0, 1.70, 69.0, 15, 15, 6, 5, 4, 0, 0, 0, 0, 0, 3, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-04/TOPURIA_ILIA_L.png?itok=oi3hU1f2'),
      ('Merab', 'Dvalishvili', 'The Machine', 'Georgia', 33, 135.0, 1.68, 66.0, 21, 17, 3, 3, 11, 4, 0, 1, 3, 0, 4, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/7/DVALISHVILI_MERAB_L_BELT_01-18.png?itok=m3PprJKJ'),
      ('Dricus', 'Du Plessis', 'Stillknocks', 'South Africa', 30, 185.0, 1.85, 76.0, 22, 20, 9, 8, 3, 2, 1, 0, 1, 0, 5, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-02/DU_PLESSIS_DRICUS_L_BELT_02-08.png?itok=eaxE5RwG'),
      ('Magomed', 'Ankalaev', 'Warrior', 'Russia', 31, 205.0, 1.91, 75.0, 20, 18, 10, 1, 7, 1, 1, 0, 0, 1, 6, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/ANKALAEV_MAGOMED_L_BELTMOCK.png?itok=AsIN2Sm-'),
      ('Belal', 'Muhammad', 'Remember the Name', 'USA', 35, 170.0, 1.80, 72.0, 25, 22, 4, 1, 17, 3, 0, 0, 3, 0, 7, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/MUHAMMAD_BELAL_L_BELTMOCK.png?itok=PyjPld2r'),
      ('Alex', 'Pereira', 'Poatan', 'Brazil', 36, 205.0, 1.93, 79.0, 12, 10, 8, 0, 2, 2, 1, 0, 1, 0, 8, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/PEREIRA_ALEX_L.png?itok=VcPMooxt'),
      ('Alexander', 'Volkanovski', 'The Great', 'Australia', 35, 145.0, 1.68, 71.5, 28, 26, 13, 3, 10, 2, 0, 0, 2, 0, 9, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2024-02/VOLKANOVSKI_ALEXANDER_L_BELT_02-17.png?itok=Yg4dyrTx'),
      ('Alexandre', 'Pantoja', 'The Cannibal', 'Brazil', 34, 125.0, 1.65, 67.0, 30, 26, 7, 10, 9, 4, 1, 1, 2, 0, 10, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/PANTOJA_ALEXANDRE_L_BELT_12-07.png?itok=qxZeUTNB'),
      ('Tom', 'Aspinall', 'No Time', 'UK', 31, 265.0, 1.96, 78.0, 16, 14, 11, 2, 1, 2, 1, 1, 0, 0, 11, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ASPINALL_TOM_BELT_L_07-27.png?itok=GKLL6fSZ'),
      ('Max', 'Holloway', 'Blessed', 'USA', 32, 145.0, 1.80, 69.0, 32, 25, 12, 2, 11, 7, 1, 0, 6, 0, 12, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2024-04/HOLLOWAY_MAX_L_04-13.png?itok=uIj6eZON'),
      ('Sean', 'O''Malley', 'Sugar', 'USA', 30, 135.0, 1.80, 72.0, 19, 17, 12, 1, 4, 1, 0, 0, 1, 1, 13, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/OMALLEY_SEAN_L_08-19.png?itok=myv3RIr7'),
      ('Charles', 'Oliveira', 'Do Bronx', 'Brazil', 34, 155.0, 1.78, 74.0, 36, 30, 9, 21, 0, 6, 2, 3, 1, 0, 14, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/OLIVEIRA_CHARLES_L_11-16.png?itok=VutZvq6g'),
      ('Arman', 'Tsarukyan', 'Ahalkalakets', 'Armenia', 27, 155.0, 1.75, 72.0, 23, 21, 8, 5, 8, 2, 1, 0, 1, 0, 15, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/TSARUKYAN_ARMAN_L_01-18.png?itok=Tz_2H31H');

-- Inserción de peleadores favoritos por usuario
INSERT INTO fav_fighters (id_user, id_fighter)
VALUES
    (1, 1),  -- John Doe's favorite fighter: Conor McGregor
    (1, 2),  -- John Doe's favorite fighter: Khabib Nurmagomedov
    (2, 3),  -- Jane Doe's favorite fighter: Nate Diaz
    (3, 1);  -- Admin's favorite fighter: Conor McGregor

-- Inserción de peleas favoritas simuladas
INSERT INTO fav_fight (id_user, id_fighter1, id_fighter2, winner, percentage, method)
VALUES
    (1, 1, 2, 1, 70.5, 'KO'),  -- John Doe's favorite fight: Conor McGregor vs Khabib Nurmagomedov (McGregor wins by KO)
    (2, 2, 3, 2, 60.3, 'Submission'),  -- Jane Doe's favorite fight: Khabib vs Nate Diaz (Khabib wins by Submission)
    (3, 1, 3, 1, 55.0, 'Decision');  -- Admin's favorite fight: Conor McGregor vs Nate Diaz (McGregor wins by Decision)
