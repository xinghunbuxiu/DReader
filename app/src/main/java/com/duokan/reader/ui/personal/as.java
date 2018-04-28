package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.ui.bookshelf.BookActionAssistant.BookAction;
import com.duokan.reader.ui.general.be;

class as implements im {
    /* renamed from: a */
    final /* synthetic */ ar f8285a;

    as(ar arVar) {
        this.f8285a = arVar;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        this.f8285a.f8282b.m11339a(false);
        this.f8285a.f8282b.m11338a(c0800c);
        this.f8285a.f8284d.mo1691d();
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        this.f8285a.f8282b.m11339a(false);
        this.f8285a.f8283c.setAction(BookAction.DOWNLOAD);
        if (!TextUtils.equals(str, "")) {
            be.m10287a(this.f8285a.f8284d.f8270a, (CharSequence) str, 0).show();
        }
    }
}
