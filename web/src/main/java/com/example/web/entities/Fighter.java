package com.example.web.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fighter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fighter")
    private Integer idFighter;

    private String name;
    private String surname;
    private String nickname;
    private String nationality;
    private int age;
    private float weight;
    private float height;
    private float reach;

    private String category;

    @Column(name = "total_fights")
    private int totalFights;

    @Column(name = "total_wins")
    private int totalWins;

    @Column(name = "wins_ko")
    private int winsKo;

    @Column(name = "wins_sub")
    private int winsSub;

    @Column(name = "wins_dec")
    private int winsDec;

    @Column(name = "total_losses")
    private int totalLosses;

    @Column(name = "losses_ko")
    private int lossesKo;

    @Column(name = "losses_sub")
    private int lossesSub;

    @Column(name = "losses_dec")
    private int lossesDec;

    @Column(name = "total_draws")
    private int totalDraws;
    private Integer ranking;
    private String image;
}
