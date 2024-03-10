package com.hroom.insertion.service.impl;

import com.hroom.insertion.repository.InsertionRepository;
// import com.hroom.insertion.repository.TenantRepository;
import com.hroom.insertion.entity.Insertion;
// import com.hroom.insertion.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

@Service
public class InsertionServiceImpl implements InsertionService{


    @Autowired
    private InsertionRepository repository;
    @Override
    public Insertion saveInsertion(Insertion insertion) {
        return repository.save(insertion);
    }

    @Override
    public List<Insertion> fetchInsertionList() {
        return (List<Insertion>)  repository.findAll();
    }

    @Override
    public Insertion updateInsertion(Insertion insertion, Long insertionId) {
        Optional<Insertion> optional = repository.findById(insertionId);
        if (optional.isEmpty()) {
            return null;
        }
        Insertion userDB = optional.get();
        if (isSanitized(insertion.getLandlord())) userDB.setLandlord(insertion.getLandlord());
        return repository.save(insertion);
    }

    @Override
    public void deleteInsertionById(Long insertionId) {
        repository.deleteById(insertionId);
    }
}
