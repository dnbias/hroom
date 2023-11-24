package com.dnbias.hroom.feedback;

import com.spike.springboot.hroom.demo.user.Tenant;

import java.sql.Timestamp;

public class FeedbackOfTennant extends Feedback{
    public FeedbackOfTennant(String writer, int rating, String description, Timestamp timestamp, String target) {
        super(writer, rating, description, timestamp, target);
    }

    public FeedbackOfTennant(String writer, int rating, String description, Timestamp timestamp, String target, TargetOfFeedback<Tenant> target1) {
        super(writer, rating, description, timestamp, target);
        this.target = target1;
    }

    private TargetOfFeedback<Tenant> target;

    @Override
    public String getTarget() {
        return target;
    }

    public void setTarget(TargetOfFeedback<Tenant> target) {
        this.target = target;
    }
}
