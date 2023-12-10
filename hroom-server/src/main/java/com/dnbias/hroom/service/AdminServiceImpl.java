package com.dnbias.hroom.service;

import com.dnbias.hroom.repository.AdminRepository;
import com.dnbias.hroom.user.Admin;
import com.dnbias.hroom.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository repository;
    @Override
    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    @Override
    public List<Admin> fetchAdminList() {
        return (List<Admin>) repository.findAll();
    }

    @Override
    public Admin updateAdmin(Admin admin, Long userId) {
        Optional<Admin> optional= repository.findById(userId);
        if(optional.isEmpty()) {
            return null;
        }
        Admin userDB = optional.get();
        if (isSanitized(admin.getUsername())) userDB.setUsername(admin.getUsername());
        if (isSanitized(admin.getName())) userDB.setName(admin.getName());
        if (isSanitized(admin.getSurname())) userDB.setSurname(admin.getSurname());
        if (isSanitized(admin.getBirthdate())) userDB.setBirthdate(admin.getBirthdate());
        if (isSanitized(admin.getCapability())) userDB.setCapability(admin.getCapability());
        if (isSanitized(admin.getPassword())) userDB.setPassword(admin.getPassword());

        return repository.save(userDB);
    }

    @Override
    public void deleteAdminById(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public void banUserById(Long userId) {
        Optional<Admin> userBan= repository.findById(userId);
        if(userBan != null) {
            System.out.println("L'utente con ID " + userId + " è stato bannato.");
        } else{
                System.out.println("Utente non trovato con ID " + userId);
        }

    }

}
