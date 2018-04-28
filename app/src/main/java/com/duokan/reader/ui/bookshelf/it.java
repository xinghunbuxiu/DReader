package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class it implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6637a;
    /* renamed from: b */
    final /* synthetic */ ie f6638b;

    it(ie ieVar, je jeVar) {
        this.f6638b = ieVar;
        this.f6637a = jeVar;
    }

    public void onClick(View view) {
        this.f6637a.requestBack();
        this.f6638b.m9849a();
    }
}
