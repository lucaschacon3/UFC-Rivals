package com.example.web.dtos;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavFightDto {
    private Integer id_fight;
    private Integer id_user;
    private Integer id_fighter1;
    private Integer id_fighter2;
    private Float percentage_f1;
    private Float percentage_f2;
}
