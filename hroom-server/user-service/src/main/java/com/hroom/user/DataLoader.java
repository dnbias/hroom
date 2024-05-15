package com.hroom.user;

import com.hroom.user.entity.Admin;
import com.hroom.user.entity.Tenant;
import com.hroom.user.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataLoader implements ApplicationRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository repository;

    @Autowired
    public DataLoader(UserRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        LOGGER.info("DataLoader > initializing DB");
        LoadTenant("dnbias","password","Daniel","B",
                   "3371231234","mail@dnbias.web");
        LoadTenant("pippo","password","Giorgio","C",
                   "3371231234","mail@gio.web");
        LoadTenant("gigi","password","Gigi","S",
                   "3334321233","mailme@gigi.com");
        LoadTenant("mario.l","password","Mario","L",
                   "3371233244","mario@gmail.web");
        LoadAdmin("admin","admin","Admin","A",
                  "XXXXXXXXXX","admin@hroom.com");
        LoadAdmin("dnbias","admin","Daniel","B",
                  "XXXXXXXXXX","dnbias@hroom.com");
    }

    void LoadTenant(String u, String p, String name, String sur,
                    String phoneNumber, String email) {
        Tenant user = new Tenant();
        user.setUsername(u);
        user.setPassword(p);
        user.setName(name);
        user.setSurname(sur);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        repository.save(user);
        LOGGER.info("DataLoader > saved user: " + user.getUsername() + ", role: tenant");
    }

    void LoadAdmin(String u, String p, String name, String sur,
                    String phoneNumber, String email) {
        Admin user = new Admin();
        user.setUsername(u);
        user.setPassword(p);
        user.setName(name);
        user.setSurname(sur);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        repository.save(user);
        LOGGER.info("DataLoader > saved user: " + user.getUsername() + ", role: admin");
    }
}
