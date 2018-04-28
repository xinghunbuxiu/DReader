package com.duokan.reader.ui.bookshelf;

import java.util.LinkedList;
import java.util.List;

public class ha extends ImportedFileInfo {
    /* renamed from: a */
    private List<ImportedFileInfo> f6536a = new LinkedList();

    public ha(String str, String str2, long j) {
        super(str, str2, j);
    }

    /* renamed from: a */
    public void m9761a(ImportedFileInfo importedFileInfo) {
        this.f6536a.add(importedFileInfo);
    }

    /* renamed from: a */
    public int m9760a() {
        return this.f6536a.size();
    }

    /* renamed from: b */
    public List<ImportedFileInfo> m9762b() {
        return this.f6536a;
    }
}
