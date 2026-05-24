package edu.icet.real_estate_system.service;

import edu.icet.real_estate_system.entity.InquiryEntity;
import edu.icet.real_estate_system.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository repository;

    public InquiryEntity submitInquiry(InquiryEntity inquiry) {
        inquiry.setInquiryDate(LocalDateTime.now());
        inquiry.setStatus("Pending");
        return repository.save(inquiry);
    }

    public List<InquiryEntity> getAllInquiries() {
        return repository.findAll();
    }

    public List<InquiryEntity> getInquiriesForProperty(Long propertyId) {
        return repository.findByPropertyId(propertyId);
    }
}