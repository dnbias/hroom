package com.hroom.admin.service;

import com.hroom.admin.entity.Admin;
import com.hroom.admin.exception.MissingUserException;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);

    List<Admin> fetchAdminList();

    Admin updateAdmin(Admin admin, Long userId) throws MissingUserException;

    void deleteAdminById(Long userId);

    public ResponseEntity<?> banTenantById(Long userId);

    public ResponseEntity<?> banLandlordById(Long userId);
}
