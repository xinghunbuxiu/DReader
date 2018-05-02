package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;
import java.util.List;

/* renamed from: com.duokan.reader.ui.bookshelf.h */
class C1291h extends dc {
    /* renamed from: a */
    final /* synthetic */ C1290g f6535a;

    C1291h(C1290g c1290g, List list, Context context) {
        this.f6535a = c1290g;
        super(list, context);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return this.f6535a.getEmptyView();
    }

    /* renamed from: b */
    public View mo505b(int i, View view, ViewGroup viewGroup) {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Tradition) {
            this.f6535a.f6492l.setVisibility(0);
        } else {
            this.f6535a.f6492l.setVisibility(8);
        }
        return this.f6535a.f6490j;
    }
}
