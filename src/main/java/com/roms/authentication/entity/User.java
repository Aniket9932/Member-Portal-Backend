package com.roms.authentication.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@RequiredArgsConstructor
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String roles;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String Address;
    private long cid;
    private String cname;

    @ElementCollection(fetch = FetchType.LAZY)
    private List<Caregiver> caregivers = new ArrayList<>();


}
