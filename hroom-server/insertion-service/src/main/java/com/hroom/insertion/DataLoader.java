package com.hroom.insertion;

import com.hroom.insertion.entity.Room;
import com.hroom.insertion.repository.InsertionRepository;
import com.hroom.insertion.entity.Features;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataLoader implements ApplicationRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private InsertionRepository repository;

    @Autowired
    public DataLoader(InsertionRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        LOGGER.info("DataLoader > initializing DB");
        Features[] features = {Features.BATHROOM, Features.HYDROMASSAGE};
        List<Long> receivedFBIds = new ArrayList<Long>();
        InputStream in = DataLoader.class.getClassLoader().
            getResourceAsStream("photos/room1.jpg");
        byte[] photoBLOB = null;
        try {
            photoBLOB = IOUtils.toByteArray(in);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return;
        }
        LOGGER.info("DataLoader > photoBLOB.length: " + photoBLOB.length);
        Room ins = new Room();
        ins.setLandlordId(1L);
        ins.setName("Appartamento Liguria");
        ins.setFeatures(features);
        ins.setDescription("Bel Appartamento");
        ins.setPrice(290.00);
        ins.setCity("Genova");
        ins.setAddress("Via Rossi 3b");
        ins.setArea(12070);
        ins.setPhoto(photoBLOB);
        ins.setMeanRating(5);
        ins.setReceivedFeedbacksIds(receivedFBIds);
        ins.setAvailabilityId(1L);
        repository.save(ins);
    }
}
