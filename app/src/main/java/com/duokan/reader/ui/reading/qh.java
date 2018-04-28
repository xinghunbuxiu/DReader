package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.C0800c;

class qh implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0800c f10861a;
    /* renamed from: b */
    final /* synthetic */ qg f10862b;

    qh(qg qgVar, C0800c c0800c) {
        this.f10862b = qgVar;
        this.f10861a = c0800c;
    }

    public void onClick(View view) {
        this.f10862b.m13847a(new qi(this));
    }
}
