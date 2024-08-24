package com.roms.authentication.service.service;

import com.roms.authentication.entity.Caregiver;

import java.util.List;

public interface CaregiverService {
    public List<Caregiver> fetchCaregiverList();

    public Caregiver fetchCaregiverById(Integer caregiverId);

    public Caregiver fetchCaregiverByName(String caregiverName);

}
