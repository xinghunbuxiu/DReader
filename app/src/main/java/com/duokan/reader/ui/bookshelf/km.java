package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.io.FileFilter;

class km implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ kf f6717a;

    km(kf kfVar) {
        this.f6717a = kfVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".ttf") || file.getName().endsWith(".otf");
    }
}
