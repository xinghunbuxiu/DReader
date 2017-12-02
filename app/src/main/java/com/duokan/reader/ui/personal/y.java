package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv.BookShelfType;

class y implements OnClickListener {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public void onClick(View view) {
        if (BookShelfType.Tradition != this.a.f) {
            this.a.b();
            this.a.f = BookShelfType.Tradition;
        }
    }
}
