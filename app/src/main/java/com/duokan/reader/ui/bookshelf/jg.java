package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnClickListener;

class jg implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ie f6659a;
    /* renamed from: b */
    final /* synthetic */ je f6660b;

    jg(je jeVar, ie ieVar) {
        this.f6660b = jeVar;
        this.f6659a = ieVar;
    }

    public void onClick(View view) {
        this.f6660b.requestBack();
    }
}
