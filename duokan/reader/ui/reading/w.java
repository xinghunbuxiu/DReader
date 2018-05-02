package com.duokan.reader.ui.reading;

import android.graphics.Rect;

class w implements adl {
    final /* synthetic */ s a;

    w(s sVar) {
        this.a = sVar;
    }

    public void a() {
        this.a.d.show();
        if (this.a.b == null || this.a.b.length <= 0) {
            Rect b = this.a.e.getDocument().k().b();
            this.a.a.b(b);
            return;
        }
        this.a.a.b(this.a.b);
    }

    public void b() {
        this.a.d.show();
        if (this.a.b == null || this.a.b.length <= 0) {
            Rect b = this.a.e.getDocument().k().b();
            this.a.a.a(b);
            return;
        }
        this.a.a.a(this.a.b);
    }
}
