package com.duokan.reader.ui.bookshelf;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;

import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

class gl implements FileFilter {
    final /* synthetic */ FileScanTask a;
    private final List b = this.a.a();

    gl(FileScanTask fileScanTask) {
        this.a = fileScanTask;
    }

    public boolean accept(File file) {
        if (file.isHidden()) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        FileType a = FileTypeRecognizer.a(absolutePath);
        if (a == FileType.UNSUPPORTED) {
            return false;
        }
        if (a == FileType.TXT) {
            try {
                if (file.length() < 51200 && absolutePath.getBytes(HTTP.UTF_8).length <= absolutePath.length()) {
                    return false;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        for (String startsWith : this.b) {
            if (absolutePath.startsWith(startsWith)) {
                return false;
            }
        }
        return true;
    }
}
