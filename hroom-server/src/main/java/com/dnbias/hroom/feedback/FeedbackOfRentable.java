package com.dnbias.hroom.feedback;

import com.dnbias.hroom.room.Insertion;
import com.dnbias.hroom.user.User;

import java.sql.Timestamp;

public class FeedbackOfRentable extends Feedback {

    public FeedbackOfRentable(User writer, int rating, String description, Timestamp timestamp, Insertion target) {
        super(writer, rating, description, timestamp, target);
    }
    private Insertion target;
}
