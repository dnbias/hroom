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
        // InputStream in = DataLoader.class.getClassLoader().
        //     getResourceAsStream("photos/room1.jpg");
        // byte[] photoBLOB = null;
        // try {
        //     photoBLOB = IOUtils.toByteArray(in);
        // } catch (Exception e) {
        //     LOGGER.error(e.getMessage());
        //     return;
        // }
        // LOGGER.info("DataLoader > photoBLOB.length: " + photoBLOB.length);
        Load(1L,"Stanza Crocetta", features, "Spaziozo", 290.00, "Torino",
             "Via Bruno 100", 12890, "photos/room1.jpg",3,new ArrayList<Long>(), 1L);
        Load(1L,"Appartamento Liguria", features, "Top Figata", 390.00, "Genova",
             "Via Venezia 3", 12810, "photos/room2.jpg",5,new ArrayList<Long>(), 2L);
    }

    void Load(Long ll, String name, Features[] fts, String des,
                     double price, String city, String addr,
                     int area, String url, int rating, ArrayList<Long> fbs,
                     Long avail) {
        Room ins = new Room();
        ins.setLandlordId(ll);
        ins.setName(name);
        ins.setFeatures(fts);
        ins.setDescription(des);
        ins.setPrice(price);
        ins.setCity(city);
        ins.setAddress(addr);
        ins.setArea(area);
        ins.setPhotoUrl(url);
        ins.setMeanRating(rating);
        ins.setReceivedFeedbacksIds(fbs);
        ins.setAvailabilityId(avail);
        repository.save(ins);
    }
}
