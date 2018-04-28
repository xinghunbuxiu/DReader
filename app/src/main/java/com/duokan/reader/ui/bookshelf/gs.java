package com.duokan.reader.ui.bookshelf;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import java.io.File;
import java.io.FileFilter;
import java.util.List;
import org.apache.http.protocol.HTTP;

class gs implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ FileScanTask f6527a;
    /* renamed from: b */
    private final List<String> f6528b = this.f6527a.m9076a();

    gs(FileScanTask fileScanTask) {
        this.f6527a = fileScanTask;
    }

    public boolean accept(File file) {
        if (file.isHidden()) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        FileType a = FileTypeRecognizer.m567a(absolutePath);
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
        for (String startsWith : this.f6528b) {
            if (absolutePath.startsWith(startsWith)) {
                return false;
            }
        }
        return true;
    }
}
