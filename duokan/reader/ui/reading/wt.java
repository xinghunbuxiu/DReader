package com.duokan.reader.ui.reading;

import java.io.File;
import java.io.FileFilter;

class wt implements FileFilter {
    final /* synthetic */ wl a;

    wt(wl wlVar) {
        this.a = wlVar;
    }

    public boolean accept(File file) {
        return file.getPath().endsWith(".snap");
    }
}
