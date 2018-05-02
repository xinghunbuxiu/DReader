package com.duokan.core.a;

import java.util.Locale;

class j {
    public static String a(String str) {
        return String.format(Locale.getDefault(), "'list-%s'", new Object[]{str});
    }
}
