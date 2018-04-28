package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;

class jz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ jg f8799a;

    jz(jg jgVar) {
        this.f8799a = jgVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setBookshelfItemStyle(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? BookshelfItemStyle.TRADITIONAL : BookshelfItemStyle.SIMPLE);
        this.f8799a.m12047a();
    }
}
