package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

/* renamed from: com.duokan.reader.ui.personal.u */
class C1413u implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1412t f9051a;

    C1413u(C1412t c1412t) {
        this.f9051a = c1412t;
    }

    public void onClick(View view) {
        if (BookShelfType.Simple != this.f9051a.f9050f) {
            this.f9051a.m12389e();
            this.f9051a.f9050f = BookShelfType.Simple;
            ReaderEnv.get().setBookShelfType(this.f9051a.f9050f);
        }
    }
}
