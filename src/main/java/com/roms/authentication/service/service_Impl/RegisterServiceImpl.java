package com.roms.authentication.service.service_Impl;

import com.roms.authentication.entity.Caregiver;
import com.roms.authentication.entity.User;
import com.roms.authentication.repository.CaregiverRepository;
import com.roms.authentication.repository.UserRepository;
import com.roms.authentication.service.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private CaregiverRepository careRepo;

    @Override
    public User saveUser(User user){
        return repo.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return repo.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDb = repo.findById(id).get();

        if(Objects.nonNull(user.getUsername()) &&
        !"".equalsIgnoreCase(user.getUsername())) {
            userDb.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getPassword()) &&
                !"".equalsIgnoreCase(user.getPassword())) {
            userDb.setPassword(user.getPassword());
        }

        if(Objects.nonNull(user.getRoles()) &&
                !"".equalsIgnoreCase(user.getRoles())) {
            userDb.setRoles(user.getRoles());
        }

        if(Objects.nonNull(user.getFirstName()) &&
                !"".equalsIgnoreCase(user.getFirstName())) {
            userDb.setFirstName(user.getFirstName());
        }

        if(Objects.nonNull(user.getLastName()) &&
                !"".equalsIgnoreCase(user.getLastName())) {
            userDb.setLastName(user.getLastName());
        }

        if(Objects.nonNull(user.getCid()) &&
                !"".equalsIgnoreCase(String.valueOf(user.getCid()))) {
            userDb.setCid(user.getCid());
        }
        if(Objects.nonNull(user.getCname()) &&
                !"".equalsIgnoreCase(user.getCname())) {
            userDb.setCname(user.getCname());
        }

        return repo.save(userDb);
    }

    @Override
    public User updateUserByName(String username, User user) {
        User userDb = repo.findByUsername(username).get();

        if(Objects.nonNull(user.getUsername()) &&
                !"".equalsIgnoreCase(user.getUsername())) {
            userDb.setUsername(user.getUsername());
        }

        if(Objects.nonNull(user.getPassword()) &&
                !"".equalsIgnoreCase(user.getPassword())) {
            userDb.setPassword(user.getPassword());
        }

        if(Objects.nonNull(user.getRoles()) &&
                !"".equalsIgnoreCase(user.getRoles())) {
            userDb.setRoles(user.getRoles());
        }

        if(Objects.nonNull(user.getFirstName()) &&
                !"".equalsIgnoreCase(user.getFirstName())) {
            userDb.setFirstName(user.getFirstName());
        }

        if(Objects.nonNull(user.getLastName()) &&
                !"".equalsIgnoreCase(user.getLastName())) {
            userDb.setLastName(user.getLastName());
        }

        if(Objects.nonNull(user.getCid()) &&
                !"".equalsIgnoreCase(String.valueOf(user.getCid()))) {
            userDb.setCid(user.getCid());
        }
        if(Objects.nonNull(user.getCname()) &&
                !"".equalsIgnoreCase(user.getCname())) {
            userDb.setCname(user.getCname());
        }

        return repo.save(userDb);
    }

    @Override
    public User fetchUserByName(String username) {
        return repo.findByUsernameIgnoreCase(username);
    }

    @Override
    public Caregiver assignCaregiver(String uname, String cname) {
        User user = this.fetchUserByName(uname);
        Caregiver caregiver = this.careRepo.findByCaregiverName(cname);

        if(user.getCaregivers().size() == 2){
            throw new RuntimeException("Caregiver limit exceeded");
        }
        user.getCaregivers().add(caregiver);
        repo.save(user);



        return caregiver;
    }


}
