-- Inserción de usuarios
INSERT INTO "user" (username, email, password, rol)
VALUES ('john_doe', 'john.doe@example.com', 'password123', 'user'),
       ('jane_doe', 'jane.doe@example.com', 'password123', 'user'),
       ('admin', 'admin@example.com', 'adminpassword', 'admin');

-- Inserción de peleadores
INSERT INTO fighter (
    name, surname, nickname, nationality, age, weight, height, reach, category,
    total_fights, total_wins, wins_ko, wins_sub, wins_dec,
    total_losses, losses_ko, losses_sub, losses_dec,
    total_draws, ranking, image
)
VALUES
    ('Islam', 'Makhachev', 'The Eagle 2.0', 'Russia', 32, 155.0, 1.78, 70.0, 'Lightweight', 26, 25, 5, 10, 10, 1, 0, 0, 1, 0, 1, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/7/MAKHACHEV_ISLAM_L_BELT_01-18.png?itok=lqIEHOin'),

    ('Jon', 'Jones', 'Bones', 'USA', 36, 205.0, 1.93, 84.5, 'Light Heavyweight', 29, 27, 10, 6, 11, 1, 0, 0, 1, 1, 2, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/JONES_JON_L_BELT_11-16.png?itok=V9GBsbVF'),

    ('Ilia', 'Topuria', 'El Matador', 'Spain', 27, 145.0, 1.70, 69.0, 'Featherweight', 15, 15, 6, 5, 4, 0, 0, 0, 0, 0, 3, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-04/TOPURIA_ILIA_L.png?itok=oi3hU1f2'),

    ('Merab', 'Dvalishvili', 'The Machine', 'Georgia', 33, 135.0, 1.68, 66.0, 'Bantamweight', 21, 17, 3, 3, 11, 4, 0, 1, 3, 0, 4, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/7/DVALISHVILI_MERAB_L_BELT_01-18.png?itok=m3PprJKJ'),

    ('Dricus', 'Du Plessis', 'Stillknocks', 'South Africa', 30, 185.0, 1.85, 76.0, 'Middleweight', 22, 20, 9, 8, 3, 2, 1, 0, 1, 0, 5, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-02/DU_PLESSIS_DRICUS_L_BELT_02-08.png?itok=eaxE5RwG'),

    ('Magomed', 'Ankalaev', 'Warrior', 'Russia', 31, 205.0, 1.91, 75.0, 'Light Heavyweight', 20, 18, 10, 1, 7, 1, 1, 0, 0, 1, 6, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/ANKALAEV_MAGOMED_L_BELTMOCK.png?itok=AsIN2Sm-'),

    ('Belal', 'Muhammad', 'Remember the Name', 'USA', 35, 170.0, 1.80, 72.0, 'Welterweight', 25, 22, 4, 1, 17, 3, 0, 0, 3, 0, 7, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/MUHAMMAD_BELAL_L_BELTMOCK.png?itok=PyjPld2r'),

    ('Alex', 'Pereira', 'Poatan', 'Brazil', 36, 205.0, 1.93, 79.0, 'Light Heavyweight', 12, 10, 8, 0, 2, 2, 1, 0, 1, 0, 8, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/PEREIRA_ALEX_L.png?itok=VcPMooxt'),

    ('Alexander', 'Volkanovski', 'The Great', 'Australia', 35, 145.0, 1.68, 71.5, 'Featherweight', 28, 26, 13, 3, 10, 2, 0, 0, 2, 0, 9, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2024-02/VOLKANOVSKI_ALEXANDER_L_BELT_02-17.png?itok=Yg4dyrTx'),

    ('Alexandre', 'Pantoja', 'The Cannibal', 'Brazil', 34, 125.0, 1.65, 67.0, 'Flyweight', 30, 26, 7, 10, 9, 4, 1, 1, 2, 0, 10, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/PANTOJA_ALEXANDRE_L_BELT_12-07.png?itok=qxZeUTNB'),

    ('Tom', 'Aspinall', 'No Time', 'UK', 31, 265.0, 1.96, 78.0, 'Heavyweight', 16, 14, 11, 2, 1, 2, 1, 1, 0, 0, 11, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ASPINALL_TOM_BELT_L_07-27.png?itok=GKLL6fSZ'),

    ('Max', 'Holloway', 'Blessed', 'USA', 32, 145.0, 1.80, 69.0, 'Featherweight', 32, 25, 12, 2, 11, 7, 1, 0, 6, 0, 12, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2024-04/HOLLOWAY_MAX_L_04-13.png?itok=uIj6eZON'),

    ('Sean', 'O''Malley', 'Sugar', 'USA', 30, 135.0, 1.80, 72.0, 'Bantamweight', 19, 17, 12, 1, 4, 1, 0, 0, 1, 1, 13, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/OMALLEY_SEAN_L_08-19.png?itok=myv3RIr7'),

    ('Charles', 'Oliveira', 'Do Bronx', 'Brazil', 34, 155.0, 1.78, 74.0, 'Lightweight', 36, 30, 9, 21, 0, 6, 2, 3, 1, 0, 14, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/OLIVEIRA_CHARLES_L_11-16.png?itok=VutZvq6g'),

    ('Arman', 'Tsarukyan', 'Ahalkalakets', 'Armenia', 27, 155.0, 1.75, 72.0, 'Lightweight', 23, 21, 8, 5, 8, 2, 1, 0, 1, 0, 15, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/TSARUKYAN_ARMAN_L_01-18.png?itok=Tz_2H31H'),

    ('Brandon', 'Royval', 'Raw Dog', 'USA', 31, 125.0, 1.73, 69.0, 'Flyweight', 21, 15, 5, 4, 6, 6, 2, 1, 3, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ROYVAL_BRANDON_L_10-12.png?itok=fxaENIvA'),

    ('Brandon', 'Moreno', 'The Assassin Baby', 'Mexico', 30, 125.0, 1.73, 66.0, 'Flyweight', 28, 20, 5, 10, 5, 6, 1, 1, 3, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/MORENO_BRANDON_L_03-29.png?itok=CnCVq4jp'),

    ('Amir', 'Albazi', 'The Prince', 'Iraq', 30, 125.0, 1.73, 70.0, 'Flyweight', 17, 16, 4, 5, 7, 1, 0, 0, 0, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ALBAZI_AMIR_L_06-03.png?itok=SVW_IOIX'),

    ('Kai', 'Kara-France', 'Don’t Blink', 'New Zealand', 30, 125.0, 1.70, 70.0, 'Flyweight', 34, 24, 10, 8, 6, 10, 3, 0, 7, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/KARA-FRANCE_KAI_L_08-17.png?itok=kP3IPaTE'),

    ('Tatsuro', 'Taira', 'The Silent Assassin', 'Japan', 24, 125.0, 1.73, 71.0, 'Flyweight', 13, 13, 3, 9, 1, 0, 0, 0, 0, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/TAIRA_TATSURO_L_12-09.png?itok=7ZMye-uF'),

    ('Manel', 'Kape', 'Starboy', 'Angola', 30, 125.0, 1.73, 74.0, 'Flyweight', 23, 17, 8, 5, 4, 6, 1, 1, 0, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-02/KAPE_MANEL_L_03-01.png?itok=O-xXM505'),

    ('Alex', 'Perez', 'The Cannibal', 'USA', 31, 125.0, 1.68, 70.0, 'Flyweight', 30, 24, 5, 4, 15, 6, 2, 1, 2, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/PEREZ_ALEX_L_06-15.png?itok=LQbMSF9K'),

    ('Asu', 'Almabayev', 'The Eagle', 'Kazakhstan', 28, 125.0, 1.70, 70.0, 'Flyweight', 21, 21, 8, 9, 4, 0, 0, 0, 1, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ALMABAYEV_ASU_L_06-15.png?itok=IfIz7Vfp'),

    ('Steve', 'Erceg', 'The Natural', 'Australia', 31, 145.0, 1.75, 72.0, 'Featherweight', 11, 10, 1, 5, 4, 1, 0, 0, 1, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ERCEG_STEVEN_L_08-17.png?itok=cZopQQ03'),

    ('Tim', 'Elliott', 'Uncle Creepy', 'USA', 37, 125.0, 1.70, 66.0, 'Flyweight', 30, 19, 3, 6, 10, 12, 2, 3, 7, 1, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ELLIOTT_TIM_L_06-03.png?itok=fbVO__7z'),

    ('Tagir', 'Ulanbekov', 'The Dagestani', 'Russia', 32, 125.0, 1.70, 70.0, 'Flyweight', 15, 14, 2, 7, 5, 1, 0, 0, 1, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/ULANBEKOV_TAGIR_L_10-21.png?itok=hdXB1Bzx'),

    ('Muhammad', 'Mokaev', 'The Punisher', 'UK', 24, 125.0, 1.75, 70.0, 'Flyweight', 12, 12, 1, 7, 4, 0, 0, 0, 0, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/MOKAEV_MUHAMMAD_L_10-21.png?itok=4jqa0Wmw'),

    ('Matt', 'Schnell', 'Danger', 'USA', 34, 125.0, 1.73, 70.0, 'Flyweight', 22, 16, 5, 7, 4, 6, 3, 2, 1, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/SCHNELL_MATT_L_12-17.png?itok=OKW5H34O'),

    ('David', 'Dvořák', 'Undertaker', 'Czech Republic', 32, 125.0, 1.73, 68.0, 'Flyweight', 25, 20, 8, 7, 5, 5, 0, 1, 4, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/DVORAK_DAVID_L_10-21.png?itok=9bLkmRAU'),

    ('Cody', 'Garbrandt', 'No Love', 'USA', 33, 135.0, 1.73, 65.0, 'Bantamweight', 19, 14, 10, 0, 4, 5, 4, 0, 1, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/GARBRANDT_CODY_L_12-16.png?itok=Srk0p3x1'),

    ('Petr', 'Yan', 'No Mercy', 'Russia', 31, 135.0, 1.70, 67.0, 'Bantamweight', 20, 16, 7, 1, 8, 4, 0, 0, 4, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/YAN_PETR_L_03-11.png?itok=g-B4ZmPg'),

    ('Song', 'Yadong', 'The Kung Fu Monkey', 'China', 26, 135.0, 1.73, 67.0, 'Bantamweight', 23, 20, 9, 3, 8, 3, 0, 0, 3, 1, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-01/5/YADONG_SONG_L_12-09.png?itok=0rsEgvZm'),

    ('Marlon', 'Vera', 'Chito', 'Ecuador', 31, 135.0, 1.73, 70.5, 'Bantamweight', 30, 21, 8, 10, 3, 9, 1, 0, 8, 0, NULL, 'https://www.ufc.com/images/styles/athlete_bio_full_body/s3/2025-03/VERA_MARLON_L_03-09.png?itok=U1Q_W_gX');




-- Inserción de peleadores favoritos por usuario
INSERT INTO fav_fighters (id_user, id_fighter)
VALUES (1, 1), -- John Doe's favorite fighter: Conor McGregor
       (1, 2), -- John Doe's favorite fighter: Khabib Nurmagomedov
       (2, 3), -- Jane Doe's favorite fighter: Nate Diaz
       (3, 1);
-- Admin's favorite fighter: Conor McGregor

-- Inserción de peleas favoritas simuladas
INSERT INTO fav_fight (id_user, id_fighter1, id_fighter2, winner, percentage, method)
VALUES (1, 1, 2, 1, 70.5,
        'KO'),                           -- John Doe's favorite fight: Conor McGregor vs Khabib Nurmagomedov (McGregor wins by KO)
       (2, 2, 3, 2, 60.3, 'Submission'), -- Jane Doe's favorite fight: Khabib vs Nate Diaz (Khabib wins by Submission)
       (3, 1, 3, 1, 55.0,
        'Decision'); -- Admin's favorite fight: Conor McGregor vs Nate Diaz (McGregor wins by Decision)
