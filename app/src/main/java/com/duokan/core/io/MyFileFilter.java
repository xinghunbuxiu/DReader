package com.duokan.core.io;

import java.io.File;
import java.io.FileFilter;


final class MyFileFilter implements FileFilter {

    final FileFilter[] fileFilters;

    MyFileFilter(FileFilter[] fileFilterArr) {
        this.fileFilters = fileFilterArr;
    }

    public boolean accept(File file) {
        if (!file.isDirectory()) {
            return false;
        }
        for (FileFilter accept : this.fileFilters) {
            if (!accept.accept(file)) {
                return false;
            }
        }
        return true;
    }
}
