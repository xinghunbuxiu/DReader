package com.duokan.reader.ui.reading;

import java.io.File;
import java.io.FileFilter;

class acc implements FileFilter {
    final /* synthetic */ acb a;

    acc(acb com_duokan_reader_ui_reading_acb) {
        this.a = com_duokan_reader_ui_reading_acb;
    }

    public boolean accept(File file) {
        if (!file.isFile() || file.getName().equalsIgnoreCase(".") || file.getName().equalsIgnoreCase("..")) {
            return false;
        }
        return true;
    }
}
