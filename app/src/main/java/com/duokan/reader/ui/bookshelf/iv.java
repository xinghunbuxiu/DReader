package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class iv implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ je f6641a;
    /* renamed from: b */
    final /* synthetic */ ie f6642b;

    iv(ie ieVar, je jeVar) {
        this.f6642b = ieVar;
        this.f6641a = jeVar;
    }

    public void onClick(View view) {
        this.f6641a.requestBack();
        this.f6642b.f6590b.m4924d();
    }
}
