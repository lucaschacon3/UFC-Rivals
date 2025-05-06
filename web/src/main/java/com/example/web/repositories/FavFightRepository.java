package com.example.web.repositories;

import com.example.web.dtos.FavFightDto;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class FavFightRepository {

    private final JdbcClient jdbcClient;

    public FavFightRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void save(FavFightDto favFight) {
        jdbcClient.sql("""
            INSERT INTO fav_fight (id_user, id_fighter1, id_fighter2, winner, percentage, method)
            VALUES (?, ?, ?, ?, ?, ?)
        """)
                .param(1, favFight.getId_user())
                .param(2, favFight.getId_fighter1())
                .param(3, favFight.getId_fighter2())
                .param(4, favFight.getWinner())
                .param(5, favFight.getPercentage())
                .param(6, favFight.getMethod())
                .update();
    }

    public void deleteById(int idFight) {
        jdbcClient.sql("DELETE FROM fav_fight WHERE id_fight = ?")
                .param(1, idFight)
                .update();
    }
}
