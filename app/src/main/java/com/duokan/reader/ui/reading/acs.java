package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;
import com.duokan.reader.domain.bookshelf.eb;

class acs implements C1447x {
    /* renamed from: a */
    final /* synthetic */ TextSelectionController f9480a;

    acs(TextSelectionController textSelectionController) {
        this.f9480a = textSelectionController;
    }

    /* renamed from: d */
    public void mo2204d() {
        this.f9480a.m12580i();
    }

    /* renamed from: e */
    public void mo2205e() {
        this.f9480a.f9159h.mo2498a(this.f9480a.m12578h(), this.f9480a.m12574f());
        this.f9480a.m12580i();
    }

    /* renamed from: b */
    public void mo2202b() {
        this.f9480a.f9163l = this.f9480a.f9159h.mo2486a(this.f9480a.m12578h(), this.f9480a.m12574f(), "");
        this.f9480a.f9156e.setSelectionDrawable(new ColorDrawable(0));
        this.f9480a.f9156e.setShowSelectionIndicators(false);
    }

    /* renamed from: c */
    public void mo2203c() {
        this.f9480a.f9159h.mo2501c(this.f9480a.f9163l);
        this.f9480a.m12580i();
    }

    /* renamed from: f */
    public void mo2206f() {
        this.f9480a.f9159h.mo2497a(this.f9480a.m12578h().mo1198g(), this.f9480a.m12574f());
        this.f9480a.m12580i();
    }

    /* renamed from: a */
    public void mo2200a() {
        this.f9480a.f9159h.mo2499a(this.f9480a.m12574f());
        this.f9480a.m12580i();
    }

    /* renamed from: a */
    public void mo2201a(int i) {
        eb.m4386a().m4388a(i);
        this.f9480a.f9163l.m4379a(eb.m4386a().m4389b());
        this.f9480a.f9159h.mo2502d(this.f9480a.f9163l);
        this.f9480a.m12580i();
    }

    /* renamed from: g */
    public void mo2207g() {
        this.f9480a.f9159h.mo2500b(this.f9480a.f9163l);
        this.f9480a.m12580i();
    }
}
