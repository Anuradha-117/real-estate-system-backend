package edu.icet.real_estate_system.controller;

import edu.icet.real_estate_system.entity.PropertyEntity;
import edu.icet.real_estate_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyService service;

    @PostMapping("/add")
    public PropertyEntity createProperty(@RequestBody PropertyEntity property) {
        return service.addProperty(property);
    }

    @GetMapping("/all")
    public List<PropertyEntity> getProperties() {
        return service.getAllProperties();
    }
}