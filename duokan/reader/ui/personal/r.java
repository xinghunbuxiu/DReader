package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.personal.BooksUploadController.UploadBookStatus;

public class r {
    private long a;
    private String b;
    private String c;
    private UploadBookStatus d;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.a;
    }

    public UploadBookStatus d() {
        return this.d;
    }

    public void a(UploadBookStatus uploadBookStatus) {
        this.d = uploadBookStatus;
    }

    public boolean e() {
        return this.d == UploadBookStatus.SELECTED || this.d == UploadBookStatus.UNSELECTED;
    }

    public r(String str, String str2, long j) {
        this.b = str;
        this.c = str2;
        this.a = j;
    }
}
