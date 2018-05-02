package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv.BookShelfType;

/* renamed from: com.duokan.reader.ui.personal.q */
class C1409q implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1408p f9042a;

    C1409q(C1408p c1408p) {
        this.f9042a = c1408p;
    }

    public void onClick(View view) {
        if (BookShelfType.Simple != this.f9042a.f9041f) {
            this.f9042a.m12379a();
            this.f9042a.f9041f = BookShelfType.Simple;
        }
    }
}
