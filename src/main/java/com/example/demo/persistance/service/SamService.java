package com.example.demo.persistance.service;

import com.example.demo.persistance.models.Sam;
import com.example.demo.persistance.repository.SamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SamService{

    @Autowired
    private SamRepository samRepository;

    public Sam save(Sam sam){
        return samRepository.save(sam);
    }
    public void deleteById(Long id){
        samRepository.deleteById(id);
    }
    public Optional<Sam> findById(Long id){
        return samRepository.findById(id);
    }
    public List<Sam> findAll() {
        return samRepository.findAll();
    }
}
