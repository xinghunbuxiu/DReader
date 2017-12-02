package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookshelfItemStyle;

class jl implements OnClickListener {
    final /* synthetic */ it a;

    jl(it itVar) {
        this.a = itVar;
    }

    public void onClick(View view) {
        ReaderEnv.get().setBookshelfItemStyle(ReaderEnv.get().getBookshelfItemStyle() == BookshelfItemStyle.SIMPLE ? BookshelfItemStyle.TRADITIONAL : BookshelfItemStyle.SIMPLE);
        this.a.a();
    }
}
