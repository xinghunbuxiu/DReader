package com.duokan.reader.domain.micloud;

import java.io.File;

public class ac {
    /* renamed from: a */
    public static boolean m8049a(File file, long j, long j2) {
        if (file.exists() && file.lastModified() == j && file.length() == j2) {
            return true;
        }
        return false;
    }
}
