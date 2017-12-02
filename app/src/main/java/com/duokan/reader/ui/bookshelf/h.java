package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

import java.util.List;

class h extends cx {
    final /* synthetic */ g a;

    h(g gVar, List list, Context context) {
        this.a = gVar;
        super(list, context);
    }

    public View a(View view, ViewGroup viewGroup) {
        return this.a.getEmptyView();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Tradition) {
            this.a.j.setVisibility(0);
        } else {
            this.a.j.setVisibility(8);
        }
        return this.a.i;
    }
}
