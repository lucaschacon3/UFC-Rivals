-- Tabla de usuarios (user)
CREATE TABLE user_app
(
    id_user  INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE  NOT NULL,
    email    VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    rol      VARCHAR(20)         NOT NULL
);

-- Tabla de peleadores (fighters)
CREATE TABLE fighter
(
    id_fighter   INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50)  NOT NULL,
    surname      VARCHAR(50)  NOT NULL,
    nickname     VARCHAR(50)  NOT NULL,
    nationality  VARCHAR(50)  NOT NULL,
    age          INT          NOT NULL,
    weight       FLOAT        NOT NULL,
    height       FLOAT        NOT NULL,
    reach        FLOAT        NOT NULL,
    category     VARCHAR(50)  NOT NULL,
    total_fights INT          NOT NULL,
    total_wins   INT          NOT NULL,
    wins_ko      INT          NOT NULL,
    wins_sub     INT          NOT NULL,
    wins_dec     INT          NOT NULL,
    total_losses INT          NOT NULL,
    losses_ko    INT          NOT NULL,
    losses_sub   INT          NOT NULL,
    losses_dec   INT          NOT NULL,
    total_draws  INT          NOT NULL,
    ranking      INT,
    image        VARCHAR(255) NOT NULL
);

-- Tabla de peleadores favoritos por usuario
CREATE TABLE fav_fighters
(
    id_user    INT,
    id_fighter INT,
    PRIMARY KEY (id_user, id_fighter),
    FOREIGN KEY (id_user) REFERENCES user_app (id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_fighter) REFERENCES fighter (id_fighter) ON DELETE CASCADE
);

-- Tabla de peleas favoritas simuladas
CREATE TABLE fav_fight
(
    id_fight    INT AUTO_INCREMENT PRIMARY KEY,
    id_user     INT NOT NULL,
    id_fighter1 INT NOT NULL,
    id_fighter2 INT NOT NULL,
    winner      INT, -- id del luchador ganador
    percentage  FLOAT,
    method      ENUM('KO', 'Submission', 'Decision'),
    FOREIGN KEY (id_user) REFERENCES user_app (id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_fighter1) REFERENCES fighter (id_fighter) ON DELETE CASCADE,
    FOREIGN KEY (id_fighter2) REFERENCES fighter (id_fighter) ON DELETE CASCADE,
    FOREIGN KEY (winner) REFERENCES fighter (id_fighter) ON DELETE SET NULL
);
