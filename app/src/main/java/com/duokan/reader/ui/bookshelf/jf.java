package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class jf implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ie f6657a;
    /* renamed from: b */
    final /* synthetic */ je f6658b;

    jf(je jeVar, ie ieVar) {
        this.f6658b = jeVar;
        this.f6657a = ieVar;
    }

    public void onClick(View view) {
        this.f6658b.requestBack();
    }
}
