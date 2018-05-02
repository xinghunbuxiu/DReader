package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv.BookShelfType;

/* renamed from: com.duokan.reader.ui.personal.r */
class C1410r implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1408p f9043a;

    C1410r(C1408p c1408p) {
        this.f9043a = c1408p;
    }

    public void onClick(View view) {
        if (BookShelfType.Tradition != this.f9043a.f9041f) {
            this.f9043a.m12380b();
            this.f9043a.f9041f = BookShelfType.Tradition;
        }
    }
}
