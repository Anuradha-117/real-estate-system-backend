package edu.icet.real_estate_system.controller;

import edu.icet.real_estate_system.entity.InquiryEntity;
import edu.icet.real_estate_system.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin
public class InquiryController {

    @Autowired
    private InquiryService service;

    @PostMapping("/submit")
    public InquiryEntity createInquiry(@RequestBody InquiryEntity inquiry) {
        return service.submitInquiry(inquiry);
    }

    @GetMapping("/all")
    public List<InquiryEntity> getAll() {
        return service.getAllInquiries();
    }

    @GetMapping("/property/{propertyId}")
    public List<InquiryEntity> getByProperty(@PathVariable Long propertyId) {
        return service.getInquiriesForProperty(propertyId);
    }
}