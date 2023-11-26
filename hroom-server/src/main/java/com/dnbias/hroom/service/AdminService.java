package com.dnbias.hroom.service;

import com.dnbias.hroom.user.Admin;
import java.util.List;

public interface AdminService {
    Admin saveAdmin(Admin admin);

    List<Admin> fetchAdminList();

    Admin updateAdmin(Admin admin, Long userId);

    void deleteAdminById(Long userId);
}
