package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class iq implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6632a;
    /* renamed from: b */
    final /* synthetic */ ie f6633b;

    iq(ie ieVar, je jeVar) {
        this.f6633b = ieVar;
        this.f6632a = jeVar;
    }

    public void onClick(View view) {
        this.f6632a.requestBack();
        this.f6633b.m9849a();
    }
}
