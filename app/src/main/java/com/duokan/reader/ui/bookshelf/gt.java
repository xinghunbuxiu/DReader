package com.duokan.reader.ui.bookshelf;

import java.util.LinkedList;
import java.util.List;

public class gt extends ImportedFileInfo {
    private List a = new LinkedList();

    public gt(String str, String str2, long j) {
        super(str, str2, j);
    }

    public void a(ImportedFileInfo importedFileInfo) {
        this.a.add(importedFileInfo);
    }

    public int a() {
        return this.a.size();
    }

    public List b() {
        return this.a;
    }
}
