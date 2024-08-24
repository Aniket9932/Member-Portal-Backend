package com.roms.authentication.controller;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.service.service_Impl.CaregiverServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class CaregiverController {

    //Mapping for caregivers

    @Autowired
    private CaregiverServiceImpl careService;

    @GetMapping("/caregivers")
    public List<Caregiver> fetchCaregiverList(){
        return careService. fetchCaregiverList();
    }

    @GetMapping("/caregivers/{id}")
    public Caregiver fetchCaregiverById(@PathVariable("id") Integer caregiverId){
        return careService.fetchCaregiverById(caregiverId);
    }

    @GetMapping("/caregivers/name/{name}")
    public Caregiver fetchCaregiverByName(@PathVariable("name") String caregiverName){
        return careService.fetchCaregiverByName(caregiverName);
    }
}
