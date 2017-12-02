package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.be;

class az implements is {
    final /* synthetic */ ay a;

    az(ay ayVar) {
        this.a = ayVar;
    }

    public void a(c cVar) {
        this.a.b.a(false);
        this.a.b.a(cVar);
        this.a.d.d();
    }

    public void a(String str) {
        this.a.b.a(false);
        this.a.c.setAction(BookAction.DOWNLOAD);
        if (!TextUtils.equals(str, "")) {
            be.a(this.a.d.a, (CharSequence) str, 0).show();
        }
    }
}
