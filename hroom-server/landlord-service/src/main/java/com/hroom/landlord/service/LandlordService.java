package com.dnbias.hroom.service;

import com.dnbias.hroom.user.Landlord;
import java.util.List;

public interface LandlordService {
    Landlord saveLandlord(Landlord landlord);

    List<Landlord> fetchLandlordList();

    Landlord updateLandlord(Landlord landlord, Long userId);

    void deleteLandlordById(Long userId);
}
