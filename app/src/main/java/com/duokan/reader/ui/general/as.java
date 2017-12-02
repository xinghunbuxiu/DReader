package com.duokan.reader.ui.general;

import com.duokan.core.ui.cs;

class as implements cs {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public void a(int i, int i2, boolean z) {
    }

    public void b(int i, int i2, boolean z) {
        if (i >= 0 && i < this.a.f.getChildCount() && i2 < this.a.f.getChildCount()) {
            this.a.a(i, i2, z);
            this.a.a(i2);
        }
    }
}
