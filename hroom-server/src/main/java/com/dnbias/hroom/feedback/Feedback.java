package com.dnbias.hroom.feedback;

import java.sql.Timestamp;

public abstract class Feedback {

   private  String writer;
   private int rating;
   private String description;
   private Timestamp timestamp;
   private String target;

    public Feedback(String writer, int rating, String description, Timestamp timestamp, String target) {
        this.writer = writer;
        this.rating = rating;
        this.description = description;
        this.timestamp = timestamp;
        this.target = target;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
