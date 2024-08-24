package com.roms.authentication.repository;

import com.roms.authentication.entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaregiverRepository extends JpaRepository<Caregiver, Integer> {

    public Caregiver findByCaregiverName(String caregiverName);

    public Caregiver findByCaregiverNameIgnoreCase(String caregiverName);


}
