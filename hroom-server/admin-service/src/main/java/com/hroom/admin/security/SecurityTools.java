package com.hroom.admin.security;

import com.hroom.admin.entity.User.Capability;
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
    public static boolean isSanitized(Object O) {
        return Objects.nonNull(O);
    }
}
