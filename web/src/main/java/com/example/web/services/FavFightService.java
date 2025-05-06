package com.example.web.services;

import com.example.web.dtos.FavFightDto;
import com.example.web.repositories.FavFightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavFightService {
    @Autowired
    private FavFightRepository favFightRepository;

    public void save(FavFightDto favFight){
        favFightRepository.save(favFight);
    }

    public void deleteById(int idFight){
        favFightRepository.deleteById(idFight);
    }
}
