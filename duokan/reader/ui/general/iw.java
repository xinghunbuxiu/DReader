package com.duokan.reader.ui.general;

import android.view.View;

class iw implements cx {
    final /* synthetic */ iu a;

    iw(iu iuVar) {
        this.a = iuVar;
    }

    public void a(int i, int i2) {
        View childAt = this.a.getChildAt(i2);
        if (childAt instanceof iy) {
            ((iy) childAt).a();
        }
        if (this.a.a != null) {
            this.a.a.a(i, i2);
        }
        if (this.a.c != null) {
            this.a.c.a(i, i2);
        }
    }
}
