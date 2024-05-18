package com.hroom.insertion;

import com.hroom.insertion.entity.Room;
import com.hroom.insertion.repository.InsertionRepository;
import com.hroom.insertion.repository.PhotoRepository;
import com.hroom.insertion.entity.Apartment;
import com.hroom.insertion.entity.Features;
import com.hroom.insertion.entity.Photo;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
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
    private final String[] filenames = {
        "foto", "foto1", "foto2", "foto3", "foto4",
        "foto5", "foto6", "foto7", "foto8", "foto9",
        "foto10", "fotox"
    };
    private InsertionRepository insertionRepository;
    private PhotoRepository photoRepository;
    private ArrayList<Long> photoArray;

    @Autowired
    public DataLoader(InsertionRepository insertionRepository,
                      PhotoRepository photoRepository) {
        this.insertionRepository = insertionRepository;
        this.photoRepository = photoRepository;
    }

    public void run(ApplicationArguments args) {
        LOGGER.info("DataLoader > initializing DB");

        LoadPhotos();
        LoadRooms();
    }

    void LoadPhotos() {
        photoArray = new ArrayList<>();

        for (String fname : filenames)
            LoadPhoto(fname);
    }

    void LoadRooms() {
        Features[] features = {Features.BATHROOM, Features.HYDROMASSAGE};
        List<Long> receivedFBIds = new ArrayList<Long>();
        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, "+
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "+
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "+
            "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "+
            "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "+
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia "+
            "deserunt mollit anim id est laborum.";

        if (photoArray.size() == 0) return;

        ArrayList<Long> photoIds = new ArrayList<>();
        photoIds.add(photoArray.get(0));
        LoadRoom(1L,"Stanza Crocetta", features, loremIpsum, 290.00, "Torino",
             "Via Bruno 100", 12890,
             photoIds ,3,new ArrayList<Long>(), 1L);
        photoIds.clear();
        photoIds.add(photoArray.get(1));
        LoadRoom(1L,"Appartamento Liguria", features, loremIpsum, 320.00, "Genova",
             "Via Venezia 3", 12810,
             photoIds,5,new ArrayList<Long>(), 2L);
        photoIds.clear();
        photoIds.add(photoArray.get(2));
        LoadRoom(1L,"Bella Stanza", features, loremIpsum, 520.30, "Milano",
             "Corso Giulia 13", 32810,
             photoIds,5,new ArrayList<Long>(), 2L);
        photoIds.clear();
        photoIds.add(photoArray.get(3));
        photoIds.add(6L);
        LoadRoom(1L,"Stanza con Vista", features, loremIpsum, 190.00, "Genova",
             "Via Venezia 3", 12810,
             photoIds,5,new ArrayList<Long>(), 2L);
        photoIds.clear();
        photoIds.add(photoArray.get(4));
        photoIds.add(photoArray.get(5));
        LoadApartment(1L,"Spazioso Appartamento", features, loremIpsum, 390.00, "Padova",
             "Via Giordano Bruno 223", 14810,
             photoIds,5,new ArrayList<Long>(), 2L, 3);
        photoIds.clear();
        photoIds.add(photoArray.get(5));
        LoadApartment(1L,"Appartamento Interessante", features, loremIpsum, 290.00, "Pisa",
             "Via Venezia 3", 52810,
             photoIds,5,new ArrayList<Long>(), 2L, 4);
        photoIds.clear();
        photoIds.add(photoArray.get(6));
        photoIds.add(photoArray.get(1));
        LoadApartment(1L,"Appartamento Luminoso", features, loremIpsum, 120.00, "Pavia",
             "Via Torino 3", 22810,
             photoIds,5,new ArrayList<Long>(), 2L, 2);
        photoIds.clear();
        photoIds.add(photoArray.get(7));
        photoIds.add(photoArray.get(8));
        LoadApartment(1L,"Residence Tranquillo", features, loremIpsum, 190.00, "Napoli",
             "Via Rodari 30", 42240,
             photoIds,5,new ArrayList<Long>(), 2L, 6);
    }

    void LoadPhoto(String name) {
        InputStream in = getClass().getClassLoader()
            .getResourceAsStream("static/photos/"+name+".jpeg");
        byte[] photoBLOB = null;
        if (in == null) {
            LOGGER.error("File Read Failed");
            return;
        }
        try {
            photoBLOB = IOUtils.toByteArray(in);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return;
        }
        Photo photo = new Photo();
        photo.setData(photoBLOB);
        LOGGER.info("DataLoader > photo.id: " + photo.getId());
        LOGGER.info("DataLoader > photoBLOB.length: " + photoBLOB.length);
        photoRepository.save(photo);
        photoArray.add(photo.getId());
    }

    void LoadRoom(Long ll, String name, Features[] fts, String des,
                     double price, String city, String addr,
                     int area, List<Long> photoIds, int rating, ArrayList<Long> fbs,
                     Long avail) {
        LOGGER.info("DataLoader > loading Room: " + name);
        Room ins = new Room();
        ins.setLandlordId(ll);
        ins.setName(name);
        ins.setFeatures(fts);
        ins.setDescription(des);
        ins.setPrice(price);
        ins.setCity(city);
        ins.setAddress(addr);
        ins.setArea(area);
        ins.setPhotoIds(photoIds);
        ins.setMeanRating(rating);
        ins.setReceivedFeedbacksIds(fbs);
        ins.setAvailabilityId(avail);
        insertionRepository.save(ins);
    }

    void LoadApartment(Long ll, String name, Features[] fts, String des,
                     double price, String city, String addr,
                     int area, List<Long> photoIds, int rating, ArrayList<Long> fbs,
                     Long avail, int nRooms) {
        LOGGER.info("DataLoader > loading Apartment: " + name);
        Apartment ins = new Apartment();
        ins.setLandlordId(ll);
        ins.setName(name);
        ins.setFeatures(fts);
        ins.setDescription(des);
        ins.setPrice(price);
        ins.setCity(city);
        ins.setAddress(addr);
        ins.setArea(area);
        ins.setPhotoIds(photoIds);
        ins.setMeanRating(rating);
        ins.setReceivedFeedbacksIds(fbs);
        ins.setAvailabilityId(avail);
        ins.setNumberOfRooms(nRooms);
        insertionRepository.save(ins);
    }
}
