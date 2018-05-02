package com.duokan.core.a;

import java.util.Locale;

class k {
    public static String a(String str) {
        return String.format(Locale.getDefault(), "'map-%s'", new Object[]{str});
    }
}
