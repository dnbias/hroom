package com.hroom.admin.service;

import com.hroom.admin.entity.Admin;
import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);

    List<Admin> fetchAdminList();

    Admin updateAdmin(Admin admin, Long userId);

    void deleteAdminById(Long userId);

    void banUserById(Long userId);

}
