package com.dnbias.hroom.service;

import com.dnbias.hroom.repository.LandlordRepository;
import com.dnbias.hroom.user.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


import static com.dnbias.hroom.security.SecurityTools.isSanitized;
@Service
public class LandlordServiceImpl implements LandlordService{

    @Autowired
    private LandlordRepository repository;
    @Override
    public Landlord saveLandlord(Landlord landlord) {
        return repository.save(landlord);
    }

    @Override
    public List<Landlord> fetchLandlordList() {
        return (List<Landlord>) repository.findAll();
    }

    @Override
    public Landlord updateLandlord(Landlord landlord, Long userId) {
        Optional<Landlord> optional = repository.findById(userId);
        if(optional.isEmpty()){
            return null;
        }
        Landlord userDB = optional.get();
        if (isSanitized(landlord.getUsername())) userDB.setUsername(landlord.getUsername());
        if (isSanitized(landlord.getName())) userDB.setName(landlord.getName());
        if (isSanitized(landlord.getSurname())) userDB.setSurname(landlord.getSurname());
        if (isSanitized(landlord.getBirthdate())) userDB.setBirthdate(landlord.getBirthdate());
        if (isSanitized(landlord.getCapability())) userDB.setCapability(landlord.getCapability());
        if (isSanitized(landlord.getPassword())) userDB.setPassword(landlord.getPassword());

        return  repository.save(userDB);
    }

    @Override
    public void deleteLandlordById(Long userId) {
        repository.deleteById(userId);

    }
}
