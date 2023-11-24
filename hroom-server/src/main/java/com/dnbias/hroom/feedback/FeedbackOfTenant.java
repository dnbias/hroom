package com.dnbias.hroom.feedback;

import com.dnbias.hroom.user.User;
import com.dnbias.hroom.user.Tenant;

import java.sql.Timestamp;

public class FeedbackOfTenant extends Feedback{
    public FeedbackOfTenant(User writer, int rating, String description, Timestamp timestamp, Tenant target) {
        super(writer, rating, description, timestamp, target);
    }

    private Tenant target;

}
