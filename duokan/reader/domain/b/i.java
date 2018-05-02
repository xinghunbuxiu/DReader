package com.duokan.reader.domain.b;

import android.text.TextUtils;

import com.duokan.common.tools;

import java.io.File;
import java.io.FileFilter;

class i implements FileFilter {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public boolean accept(File file) {
        String a = tools.substringwerCase(file.getName());
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        if (a.equalsIgnoreCase("ttf") || a.equalsIgnoreCase("otf")) {
            return true;
        }
        return false;
    }
}
