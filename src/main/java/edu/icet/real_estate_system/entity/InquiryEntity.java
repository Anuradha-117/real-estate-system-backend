package edu.icet.real_estate_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inquiries")
public class InquiryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long propertyId;
    private String customerEmail;

    private String message;
    private String contactNumber;

    private String status; //Pending,Contacted or Resolved
    private LocalDateTime inquiryDate;
}