package com.hroom.insertion.security;

import java.util.Date;
import java.util.Objects;

public class SecurityTools {
    public static boolean isSanitized(Object o) {
        return Objects.nonNull(o);
    }
    public static boolean isSanitized(String s) {
        return Objects.nonNull(s) && !s.isEmpty();
    }
    public static boolean isSanitized(Date d) {
        return Objects.nonNull(d);
    }
}
