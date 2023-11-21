package com.spike.springboot.hroom.demo.feedback;

import com.spike.springboot.hroom.demo.room.Rentable;

import java.sql.Timestamp;

public class FeedbackOfRentable extends Feedback {

    public FeedbackOfRentable(String writer, int rating, String description, Timestamp timestamp, String target, TargetOfFeedback<Rentable> target1) {
        super(writer, rating, description, timestamp, target);
        this.target = target1;
    }
    private TargetOfFeedback<Rentable> target;
}
