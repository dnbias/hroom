package com.dnbias.hroom.feedback;

import com.dnbias.hroom.user.User;

import java.sql.Timestamp;

public abstract class Feedback {
   private User writer;
   private int rating;
   private String description;
   private Timestamp timestamp;
   private TargetOfFeedback target;

    public Feedback(User writer, int rating, String description, Timestamp timestamp, TargetOfFeedback target) {
        this.writer = writer;
        this.rating = rating;
        this.description = description;
        this.timestamp = timestamp;
        this.target = target;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public TargetOfFeedback getTarget() {
        return target;
    }

    public void setTarget(TargetOfFeedback target) {
        this.target = target;
    }
}
