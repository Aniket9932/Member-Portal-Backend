package com.roms.authentication.service.service_Impl;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.repository.CaregiverRepository;
import com.roms.authentication.service.service.CaregiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaregiverServiceImpl implements CaregiverService {

    @Autowired
    private CaregiverRepository careRepo;


    @Override
    public List<Caregiver> fetchCaregiverList(){
        return careRepo.findAll();
    }

    @Override
    public Caregiver fetchCaregiverById(Integer caregiverId) {
        return careRepo.findById(caregiverId).get();
    }

    @Override
    public Caregiver fetchCaregiverByName(String caregiverName) {
        return careRepo.findByCaregiverNameIgnoreCase(caregiverName);
    }
}
