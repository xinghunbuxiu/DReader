package com.duokan.reader.ui.reading;

import java.io.File;
import java.io.FileFilter;

class acp implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ aco f9478a;

    acp(aco aco) {
        this.f9478a = aco;
    }

    public boolean accept(File file) {
        if (!file.isFile() || file.getName().equalsIgnoreCase(".") || file.getName().equalsIgnoreCase("..")) {
            return false;
        }
        return true;
    }
}
