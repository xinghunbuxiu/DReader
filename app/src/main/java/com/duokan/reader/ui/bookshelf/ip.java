package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class ip implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6630a;
    /* renamed from: b */
    final /* synthetic */ ie f6631b;

    ip(ie ieVar, je jeVar) {
        this.f6631b = ieVar;
        this.f6630a = jeVar;
    }

    public void onClick(View view) {
        this.f6630a.requestBack();
        this.f6631b.f6590b.m4927g();
    }
}
