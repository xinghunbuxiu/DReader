package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class is implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6635a;
    /* renamed from: b */
    final /* synthetic */ ie f6636b;

    is(ie ieVar, je jeVar) {
        this.f6636b = ieVar;
        this.f6635a = jeVar;
    }

    public void onClick(View view) {
        this.f6635a.requestBack();
        this.f6636b.f6590b.m4923c();
    }
}
