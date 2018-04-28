package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.bookshelf.C0800c;

class ur implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0800c f11029a;
    /* renamed from: b */
    final /* synthetic */ uq f11030b;

    ur(uq uqVar, C0800c c0800c) {
        this.f11030b = uqVar;
        this.f11029a = c0800c;
    }

    public void onClick(View view) {
        this.f11030b.m13847a(new us(this));
    }
}
