package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;

/* renamed from: com.duokan.reader.ui.personal.w */
class C1415w implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1412t f9053a;

    C1415w(C1412t c1412t) {
        this.f9053a = c1412t;
    }

    public void onClick(View view) {
        ReaderEnv.get().setBookshelfItemStyle(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? BookshelfItemStyle.TRADITIONAL : BookshelfItemStyle.SIMPLE);
        this.f9053a.f9049e.setSelected(ReaderEnv.get().getBookshelfItemStyle() != BookshelfItemStyle.SIMPLE);
    }
}
