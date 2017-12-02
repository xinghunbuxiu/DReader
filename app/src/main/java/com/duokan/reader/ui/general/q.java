package com.duokan.reader.ui.general;

import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;

class q implements w {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public void a() {
        try {
            if (DkApp.get().getTopActivity() != null) {
                this.a.a.f.a(new n(this.a.a.i, this.a.a.d));
                this.a.a.h.a(false);
                this.a.a.g = CoverSource.NONE;
            }
        } catch (Exception e) {
            this.a.a.b();
        }
    }

    public void b() {
        this.a.a.b();
    }
}
