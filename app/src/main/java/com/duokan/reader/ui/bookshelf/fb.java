package com.duokan.reader.ui.bookshelf;

import java.io.File;
import java.util.List;

class fb implements gp {
    /* renamed from: a */
    final /* synthetic */ ey f6431a;

    fb(ey eyVar) {
        this.f6431a = eyVar;
    }

    /* renamed from: a */
    public void mo1690a(String str) {
        List a = this.f6431a.m9582b(str);
        if (new File(str).canRead() && a != null && !a.isEmpty()) {
            this.f6431a.f6425f.setPath(str);
            this.f6431a.setData(this.f6431a.m9582b(str));
        }
    }
}
