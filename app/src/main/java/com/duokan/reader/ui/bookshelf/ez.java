package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

final class ez implements Comparator<File> {
    /* renamed from: a */
    private Collator f6428a = Collator.getInstance(Locale.CHINESE);

    ez() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9592a((File) obj, (File) obj2);
    }

    /* renamed from: a */
    public int m9592a(File file, File file2) {
        if (file.isDirectory() == file2.isDirectory()) {
            return this.f6428a.compare(file.getName(), file2.getName());
        }
        return file.isDirectory() ? 1 : -1;
    }
}
