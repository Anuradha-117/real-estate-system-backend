package edu.icet.real_estate_system.controller;

import edu.icet.real_estate_system.entity.PropertyEntity;
import edu.icet.real_estate_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {

    @Autowired
    private PropertyService service;

    @PostMapping(value = "/add", consumes = {"multipart/form-data"})
    public PropertyEntity createProperty(
            @RequestPart("property") String propertyJson,
            @RequestPart(value = "file", required = false) MultipartFile file) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        PropertyEntity property = objectMapper.readValue(propertyJson, PropertyEntity.class);

        if (file != null && !file.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path savePath = Paths.get("uploads/");
            if (!Files.exists(savePath)) {
                Files.createDirectories(savePath);
            }
            Files.copy(file.getInputStream(), savePath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            property.setImageUrl("/uploads/" + fileName);
        }
        return service.addProperty(property);
    }

    @GetMapping("/all")
    public List<PropertyEntity> getProperties() {
        return service.getAllProperties();
    }

    @PutMapping("/update/{id}")
    public PropertyEntity updateProperty(@PathVariable Long id, @RequestBody PropertyEntity property) {
        return service.updateProperty(id, property);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable Long id) {
        service.deleteProperty(id);
    }
}