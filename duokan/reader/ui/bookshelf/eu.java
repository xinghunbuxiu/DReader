package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.util.List;

class eu implements gi {
    final /* synthetic */ er a;

    eu(er erVar) {
        this.a = erVar;
    }

    public void a(String str) {
        List a = this.a.b(str);
        if (new File(str).canRead() && a != null && !a.isEmpty()) {
            this.a.f.setPath(str);
            this.a.setData(this.a.b(str));
        }
    }
}
