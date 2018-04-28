package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;

class bt implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ bs f6215a;

    bt(bs bsVar) {
        this.f6215a = bsVar;
    }

    public void onCancel(C0301c c0301c) {
        this.f6215a.f6214f = true;
        this.f6215a.close();
        this.f6215a.f6211c.dismiss();
    }
}
