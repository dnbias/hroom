package com.hroom.feedback;

import com.hroom.feedback.entity.FeedbackOfTenant;
import com.hroom.feedback.repository.FeedbackRepository;
import com.hroom.feedback.entity.FeedbackOfInsertion;
import com.hroom.feedback.entity.Feedback;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DataLoader implements ApplicationRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private FeedbackRepository repository;
    final String pattern = "MM-dd-yyyy HH:mm:ss";
    final DateFormat df = new SimpleDateFormat(pattern);

    public void run(ApplicationArguments args) {
        LOGGER.info("DataLoader > initializing DB");
        ArrayList<Feedback> feedbacks = new ArrayList<>();

       feedbacks.add(LoadFeedbackInsertion(1L, 1L, 5, "Ottima offerta!"));
       feedbacks.add(LoadFeedbackInsertion(2L, 1L, 4, "Appartamento molto bello."));
       feedbacks.add(LoadFeedbackInsertion(3L, 1L, 4, "Molto bello."));
       feedbacks.add(LoadFeedbackInsertion(1L, 2L, 4, "Molto bello."));
       feedbacks.add(LoadFeedbackInsertion(2L, 2L, 5, "Appartamento molto bello."));
       feedbacks.add(LoadFeedbackTenant(3L, 1L, 4, "Ottimo cliente."));
       feedbacks.add(LoadFeedbackTenant(2L, 1L, 4, "Buon cliente."));

        for (Feedback f : feedbacks)
            repository.save(f);
    }

    FeedbackOfInsertion LoadFeedbackInsertion(Long t_id, Long i_id,
                                              int rating, String desc) {
        FeedbackOfInsertion fb = new FeedbackOfInsertion();
        String t = df.format(new Date());

        fb.setTenantId(t_id);
        fb.setInsertionId(i_id);
        fb.setRating(rating);
        fb.setDescription(desc);
        fb.setTimestamp(t);

        return fb;
    }

    FeedbackOfTenant LoadFeedbackTenant(Long l_id, Long t_id,
                                              int rating, String desc) {
        FeedbackOfTenant fb = new FeedbackOfTenant();
        String t = df.format(new Date());

        fb.setLandlordId(t_id);
        fb.setTenantId(l_id);
        fb.setRating(rating);
        fb.setDescription(desc);
        fb.setTimestamp(t);

        return fb;
    }
}
