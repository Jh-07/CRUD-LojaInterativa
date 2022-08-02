package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Manufacturer;
import com.example.demo.service.ManufacturerService;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerResource {
    private ManufacturerService ManufacturerService;
    
    @Autowired
    public ManufacturerResource(ManufacturerService ManufacturerService) {
        this.ManufacturerService = ManufacturerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody Manufacturer Manufacturer){
        this.ManufacturerService.addManufacturer(Manufacturer);
        return new ResponseEntity<>(Manufacturer, HttpStatus.CREATED);
    }
    
    @GetMapping("/list")
    public  ResponseEntity<List<Manufacturer>> getManufacturers(){
        List<Manufacturer> Manufacturers = ManufacturerService.getAllManufacturer();
        return new ResponseEntity<>(Manufacturers, HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<Manufacturer> updateManufacturer(@RequestBody Manufacturer Manufacturer){
        Manufacturer updatedManufacturer = ManufacturerService.addManufacturer(Manufacturer); 
        return new ResponseEntity<>(updatedManufacturer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteManufacturerById(@PathVariable Long id){
        ManufacturerService.deleteManufacturerById(id);
    }
    
}


