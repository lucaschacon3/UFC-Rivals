package com.example.web.services;

import com.example.web.dtos.FavFightDto;
import com.example.web.dtos.FavFighterDto;
import com.example.web.repositories.FavFighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavFighterService {

    @Autowired
    private FavFighterRepository favFighterRepository;

    public void save(int id_user_app, int fighter_id) {
        favFighterRepository.save(id_user_app, fighter_id);
    }

    public void deleteById(int idFighter) {
        favFighterRepository.deleteById(idFighter);
    }

    public List<FavFighterDto> findByIdUserApp(int idUserApp) {
        return favFighterRepository.findByIdUserApp(idUserApp);

    }
    public List<Integer> findIdFighterByIdUserApp(int idUserApp) {
        return favFighterRepository.findIdFighterByIdUserApp(idUserApp);

    }
}
