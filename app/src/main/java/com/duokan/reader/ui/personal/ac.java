package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

class ac implements OnClickListener {
    final /* synthetic */ aa a;

    ac(aa aaVar) {
        this.a = aaVar;
    }

    public void onClick(View view) {
        if (BookShelfType.Tradition != this.a.f) {
            this.a.d();
            this.a.f = BookShelfType.Tradition;
            ReaderEnv.get().setBookShelfType(this.a.f);
        }
    }
}
