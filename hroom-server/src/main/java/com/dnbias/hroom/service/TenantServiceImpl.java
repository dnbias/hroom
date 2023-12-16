package com.dnbias.hroom.service;

import com.dnbias.hroom.repository.TenantRepository;

import com.dnbias.hroom.user.Tenant;
import com.dnbias.hroom.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantRepository repository;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return repository.save(tenant);
    }

    @Override
    public List<Tenant> fetchTenantList() {
        return (List<Tenant>) repository.findAll();
    }

    @Override
    public Tenant findById(Long userId) {
        Optional<Tenant> optional = repository.findById(userId);
        if (optional.isEmpty()) {
            throw new MissingUserException(userId);
            return null;
        }
        return optional.get();
    }

    @Override
    public Tenant updateTenant(Tenant tenant, Long userId) {
        Optional<Tenant> optional = repository.findById(userId);
        if (optional.isEmpty()) {
            throw new MissingUserException(userId);
            return null;
        }

        Tenant userDB = optional.get();

        if (isSanitized(tenant.getUsername())) userDB.setUsername(tenant.getUsername());
        if (isSanitized(tenant.getName())) userDB.setName(tenant.getName());
        if (isSanitized(tenant.getSurname())) userDB.setSurname(tenant.getSurname());
        if (isSanitized(tenant.getBirthdate())) userDB.setBirthdate(tenant.getBirthdate());
        if (isSanitized(tenant.getCapability())) userDB.setCapability(tenant.getCapability());
        if (isSanitized(tenant.getPassword())) userDB.setPassword(tenant.getPassword());

        return repository.save(userDB);
    }

    @Override
    public void deleteTenantById(Long userId) {
        repository.deleteById(userId);
    }



}
