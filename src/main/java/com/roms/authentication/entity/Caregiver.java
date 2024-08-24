package com.roms.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Caregiver")
public class Caregiver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int caregiverId;

    private String caregiverName;

    private String phone;



}
