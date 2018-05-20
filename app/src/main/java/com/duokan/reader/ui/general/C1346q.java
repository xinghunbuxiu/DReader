package com.duokan.reader.ui.general;

import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;

/* renamed from: com.duokan.reader.ui.general.q */
class C1346q implements C1345w {
    /* renamed from: a */
    final /* synthetic */ C1344p f7548a;

    C1346q(C1344p c1344p) {
        this.f7548a = c1344p;
    }

    /* renamed from: a */
    public void mo1810a() {
        try {
            if (DkApp.get().getTopActivity() != null) {
                this.f7548a.f7547a.f7542f.m10719a(new CustomGlideUrl(this.f7548a.f7547a.f7545i, this.f7548a.f7547a.f7540d));
                this.f7548a.f7547a.f7544h.mo1793a(false);
                this.f7548a.f7547a.f7543g = CoverSource.NONE;
            }
        } catch (Exception e) {
            this.f7548a.f7547a.m10948b();
        }
    }

    /* renamed from: b */
    public void mo1811b() {
        this.f7548a.f7547a.m10948b();
    }
}
