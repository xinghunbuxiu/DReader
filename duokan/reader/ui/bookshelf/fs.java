package com.duokan.reader.ui.bookshelf;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class fs implements Comparator {
    final /* synthetic */ fr a;
    private Collator b = Collator.getInstance(Locale.CHINESE);

    fs(fr frVar) {
        this.a = frVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((ImportedFileInfo) obj, (ImportedFileInfo) obj2);
    }

    public int a(ImportedFileInfo importedFileInfo, ImportedFileInfo importedFileInfo2) {
        return this.b.compare(importedFileInfo.d(), importedFileInfo2.d());
    }
}
