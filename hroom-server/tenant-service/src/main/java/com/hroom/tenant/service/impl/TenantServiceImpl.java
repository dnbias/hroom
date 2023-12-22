package com.hroom.tenant.service.impl;

import com.hroom.tenant.exception.MissingUserException;
import com.hroom.tenant.repository.TenantRepository;
import com.hroom.tenant.service.TenantService;
import com.hroom.tenant.entity.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.hroom.tenant.security.SecurityTools.isSanitized;

@Service
public class TenantServiceImpl implements TenantService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private TenantRepository repository;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        LOGGER.info("TenantServiceImpl > saveTenant started");
        return repository.save(tenant);
    }

    @Override
    public List<Tenant> fetchTenantList() {
        LOGGER.info("TenantServiceImpl > fetchTenantList started");
        return (List<Tenant>) repository.findAll();
    }

    @Override
    public Tenant findById(Long userId) throws MissingUserException {
        LOGGER.info("TenantServiceImpl > findById started");
        Optional<Tenant> optional = repository.findById(userId);

        if (optional.isEmpty()) {
            throw new MissingUserException(userId);
        }

        return optional.get();
    }

    @Override
    public Tenant updateTenant(Tenant tenant, Long userId)
        throws MissingUserException {
        LOGGER.info("TenantServiceImpl > updateTenant started");
        Optional<Tenant> optional = repository.findById(userId);

        if (optional.isEmpty()) {
            throw new MissingUserException(userId);
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
        LOGGER.info("TenantServiceImpl > deleteTenantById started");
        repository.deleteById(userId);
    }
}
