package edu.icet.real_estate_system.service;

import edu.icet.real_estate_system.entity.PropertyEntity;
import edu.icet.real_estate_system.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repository;

    public PropertyEntity addProperty(PropertyEntity property) {
        if (property.getStatus() == null || property.getStatus().isEmpty()) {
            property.setStatus("Available");
        }
        return repository.save(property);
    }

    public List<PropertyEntity> getAllProperties() {
        return repository.findAll();
    }

    public PropertyEntity updateProperty(Long id, PropertyEntity updatedProperty) {
        Optional<PropertyEntity> existingPropertyOpt = repository.findById(id);

        if (existingPropertyOpt.isPresent()) {
            PropertyEntity existingProperty = existingPropertyOpt.get();
            existingProperty.setTitle(updatedProperty.getTitle());
            existingProperty.setLocation(updatedProperty.getLocation());
            existingProperty.setPrice(updatedProperty.getPrice());
            existingProperty.setPropertyType(updatedProperty.getPropertyType());
            existingProperty.setStatus(updatedProperty.getStatus());

            return repository.save(existingProperty);
        } else {
            throw new RuntimeException("Property not found with ID: " + id);
        }
    }

    public void deleteProperty(Long id) {
        repository.deleteById(id);
    }

}