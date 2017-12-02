package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

final class es implements Comparator {
    private Collator a = Collator.getInstance(Locale.CHINESE);

    es() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }

    public int a(File file, File file2) {
        if (file.isDirectory() == file2.isDirectory()) {
            return this.a.compare(file.getName(), file2.getName());
        }
        return file.isDirectory() ? 1 : -1;
    }
}
