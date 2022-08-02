package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manufacturer;
import com.example.demo.repository.ManufacturerRepository;

@Service
public class ManufacturerService {
    private ManufacturerRepository ManufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository){
        this.ManufacturerRepository = manufacturerRepository;
    }

    public Manufacturer addManufacturer(Manufacturer Manufacturer){
        return ManufacturerRepository.save(Manufacturer);
    }
    public Manufacturer updateManufacturer(Manufacturer Manufacturer){
        return ManufacturerRepository.save(Manufacturer);
    }

    public List<Manufacturer> getAllManufacturer(){
        return ManufacturerRepository.findAll();
    }

    public void deleteManufacturerById(Long id){
        ManufacturerRepository.deleteById(id);
    }
}


