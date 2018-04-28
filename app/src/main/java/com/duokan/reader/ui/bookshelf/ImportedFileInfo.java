package com.duokan.reader.ui.bookshelf;

public class ImportedFileInfo {
    /* renamed from: a */
    private long f6031a;
    /* renamed from: b */
    private String f6032b;
    /* renamed from: c */
    private String f6033c;
    /* renamed from: d */
    private FileStatus f6034d;

    public enum FileStatus {
        UNSELECTED,
        SELECTED,
        IMPORTED
    }

    /* renamed from: c */
    public String m9084c() {
        return this.f6032b;
    }

    /* renamed from: d */
    public String m9085d() {
        return this.f6033c;
    }

    /* renamed from: e */
    public long m9086e() {
        return this.f6031a;
    }

    /* renamed from: f */
    public FileStatus m9087f() {
        return this.f6034d;
    }

    /* renamed from: a */
    public void m9083a(FileStatus fileStatus) {
        this.f6034d = fileStatus;
    }

    public ImportedFileInfo(String str, String str2, long j) {
        this.f6032b = str;
        this.f6033c = str2;
        this.f6031a = j;
    }
}
