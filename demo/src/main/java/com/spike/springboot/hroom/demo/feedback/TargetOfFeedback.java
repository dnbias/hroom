package com.spike.springboot.hroom.demo.feedback;

import com.spike.springboot.hroom.demo.user.User;

import java.sql.Timestamp;

public class TargetOfFeedback<T extends User> extends Feedback{
    public TargetOfFeedback(String writer, int rating, String description, Timestamp timestamp, String target) {
        super(writer, rating, description, timestamp, target);
    }

}
