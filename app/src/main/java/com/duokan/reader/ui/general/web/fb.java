package com.duokan.reader.ui.general.web;

import android.graphics.Rect;

import com.duokan.core.sys.as;
import com.duokan.reader.ui.general.bx;

class fb implements as {
    final /* synthetic */ Rect a;
    final /* synthetic */ String[] b;
    final /* synthetic */ String c;
    final /* synthetic */ fa d;

    fb(fa faVar, Rect rect, String[] strArr, String str) {
        this.d = faVar;
        this.a = rect;
        this.b = strArr;
        this.c = str;
    }

    public void a() {
        int i = 0;
        this.a.offset(0, this.d.b.b.mPageHeaderView == null ? 0 : this.d.b.b.mPageHeaderView.getHeight());
        bx bxVar = new bx(this.d.b.b.getContext(), true);
        while (i < this.b.length) {
            bxVar.a(this.b[i]);
            i++;
        }
        bxVar.a(new fc(this));
        bxVar.a(this.a);
        bxVar.open(new fd(this));
    }
}
