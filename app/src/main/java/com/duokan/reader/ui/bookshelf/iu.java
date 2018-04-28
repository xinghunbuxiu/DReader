package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class iu implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6639a;
    /* renamed from: b */
    final /* synthetic */ ie f6640b;

    iu(ie ieVar, je jeVar) {
        this.f6640b = ieVar;
        this.f6639a = jeVar;
    }

    public void onClick(View view) {
        this.f6639a.requestBack();
        this.f6640b.f6590b.m4923c();
    }
}
