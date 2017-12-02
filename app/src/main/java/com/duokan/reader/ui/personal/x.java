package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv.BookShelfType;

class x implements OnClickListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public void onClick(View view) {
        if (BookShelfType.Simple != this.a.f) {
            this.a.a();
            this.a.f = BookShelfType.Simple;
        }
    }
}
