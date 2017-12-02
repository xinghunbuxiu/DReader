package com.duokan.reader.ui.bookshelf;

public class ImportedFileInfo {
    private long a;
    private String b;
    private String c;
    private FileStatus d;

    public enum FileStatus {
        UNSELECTED,
        SELECTED,
        IMPORTED
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public long e() {
        return this.a;
    }

    public FileStatus f() {
        return this.d;
    }

    public void a(FileStatus fileStatus) {
        this.d = fileStatus;
    }

    public ImportedFileInfo(String str, String str2, long j) {
        this.b = str;
        this.c = str2;
        this.a = j;
    }
}
