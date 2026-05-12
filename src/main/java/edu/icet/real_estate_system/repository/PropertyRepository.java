package edu.icet.real_estate_system.repository;

import edu.icet.real_estate_system.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

}