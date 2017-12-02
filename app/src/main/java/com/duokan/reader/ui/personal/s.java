package com.duokan.reader.ui.personal;

import com.duokan.reader.ui.personal.BooksUploadController.UploadBookStatus;

import java.util.List;

public class s {
    private String a;
    private String b;
    private UploadBookStatus c;
    private List d;

    public String a() {
        return this.b;
    }

    public List b() {
        return this.d;
    }

    public UploadBookStatus c() {
        return this.c;
    }

    public void a(UploadBookStatus uploadBookStatus) {
        this.c = uploadBookStatus;
    }

    public int d() {
        return this.d == null ? 0 : this.d.size();
    }

    public int e() {
        if (this.d == null) {
            return 0;
        }
        int i = 0;
        for (r e : this.d) {
            if (e.e()) {
                i++;
            }
        }
        return i;
    }

    public boolean f() {
        return this.c == UploadBookStatus.SELECTED || this.c == UploadBookStatus.UNSELECTED;
    }

    public s(String str, String str2, List list) {
        this.a = str;
        this.b = str2;
        this.d = list;
    }
}
