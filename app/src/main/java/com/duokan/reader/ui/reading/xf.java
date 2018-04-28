package com.duokan.reader.ui.reading;

import java.io.File;
import java.util.Comparator;

class xf implements Comparator<File> {
    /* renamed from: a */
    final /* synthetic */ wy f11141a;

    xf(wy wyVar) {
        this.f11141a = wyVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15063a((File) obj, (File) obj2);
    }

    /* renamed from: a */
    public int m15063a(File file, File file2) {
        if (file.lastModified() == file2.lastModified()) {
            return 0;
        }
        if (file.lastModified() > file2.lastModified()) {
            return 1;
        }
        return -1;
    }
}
