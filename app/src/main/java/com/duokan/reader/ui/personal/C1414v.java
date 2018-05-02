package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

/* renamed from: com.duokan.reader.ui.personal.v */
class C1414v implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1412t f9052a;

    C1414v(C1412t c1412t) {
        this.f9052a = c1412t;
    }

    public void onClick(View view) {
        if (BookShelfType.Tradition != this.f9052a.f9050f) {
            this.f9052a.m12390f();
            this.f9052a.f9050f = BookShelfType.Tradition;
            ReaderEnv.get().setBookShelfType(this.f9052a.f9050f);
        }
    }
}
