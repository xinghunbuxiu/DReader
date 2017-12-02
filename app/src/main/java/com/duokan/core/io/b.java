package com.duokan.core.io;

import java.io.File;
import java.io.FileFilter;

final class b implements FileFilter {
    final /* synthetic */ FileFilter[] a;

    b(FileFilter[] fileFilterArr) {
        this.a = fileFilterArr;
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        for (FileFilter accept : this.a) {
            if (!accept.accept(file)) {
                return false;
            }
        }
        return true;
    }
}
