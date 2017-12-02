package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

class ab implements OnClickListener {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void onClick(View view) {
        if (BookShelfType.Simple != this.a.f) {
            this.a.c();
            this.a.f = BookShelfType.Simple;
            ReaderEnv.get().setBookShelfType(this.a.f);
        }
    }
}
