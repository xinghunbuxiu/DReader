package com.duokan.reader.ui.reading;

import java.io.File;
import java.util.Comparator;

class ws implements Comparator {
    final /* synthetic */ wl a;

    ws(wl wlVar) {
        this.a = wlVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }

    public int a(File file, File file2) {
        if (file.lastModified() == file2.lastModified()) {
            return 0;
        }
        if (file.lastModified() > file2.lastModified()) {
            return 1;
        }
        return -1;
    }
}
