package com.dnbias.hroom.security;

import com.dnbias.hroom.user.User.Capability;
import java.util.Date;
import java.util.Objects;

public class SecurityTools {

    public static boolean isSanitized(String s) {
        return Objects.nonNull(s) && !s.isEmpty();
    }
    public static boolean isSanitized(Date d) {
        return Objects.nonNull(d);
    }
    public static boolean isSanitized(Capability c) {
        return Objects.nonNull(c);
    }
}
