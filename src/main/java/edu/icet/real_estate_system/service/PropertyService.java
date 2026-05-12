package edu.icet.real_estate_system.service;

import edu.icet.real_estate_system.entity.PropertyEntity;
import edu.icet.real_estate_system.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public PropertyEntity addProperty(PropertyEntity property) {
        // automtclly set availbl when add a new property
        property.setStatus("Available");
        return repository.save(property);
    }

    public List<PropertyEntity> getAllProperties() {
        return repository.findAll();
    }
}