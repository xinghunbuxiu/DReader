package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.io.FileFilter;

class jo implements FileFilter {
    final /* synthetic */ jh a;

    jo(jh jhVar) {
        this.a = jhVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".ttf") || file.getName().endsWith(".otf");
    }
}
