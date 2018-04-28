package com.duokan.reader.ui.bookshelf;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class fz implements Comparator<ImportedFileInfo> {
    /* renamed from: a */
    final /* synthetic */ fy f6479a;
    /* renamed from: b */
    private Collator f6480b = Collator.getInstance(Locale.CHINESE);

    fz(fy fyVar) {
        this.f6479a = fyVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m9655a((ImportedFileInfo) obj, (ImportedFileInfo) obj2);
    }

    /* renamed from: a */
    public int m9655a(ImportedFileInfo importedFileInfo, ImportedFileInfo importedFileInfo2) {
        return this.f6480b.compare(importedFileInfo.m9085d(), importedFileInfo2.m9085d());
    }
}
