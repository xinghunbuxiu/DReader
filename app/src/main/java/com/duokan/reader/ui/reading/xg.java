package com.duokan.reader.ui.reading;

import java.io.File;
import java.io.FileFilter;

class xg implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ wy f11142a;

    xg(wy wyVar) {
        this.f11142a = wyVar;
    }

    public boolean accept(File file) {
        return file.getPath().endsWith(".snap");
    }
}
