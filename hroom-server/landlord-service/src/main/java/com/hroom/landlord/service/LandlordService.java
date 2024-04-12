package com.hroom.landlord.service;

import com.hroom.landlord.entity.Landlord;
import java.util.List;

public interface LandlordService {
    Landlord saveLandlord(Landlord landlord);

    List<Landlord> fetchLandlordList();

    Landlord updateLandlord(Landlord landlord, Long userId);

    void deleteLandlordById(Long userId);
}
