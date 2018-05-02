package com.duokan.reader.ui.reading;

import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.ad.C0745b;

/* renamed from: com.duokan.reader.ui.reading.f */
class C1454f implements C0745b {
    /* renamed from: a */
    final /* synthetic */ C1452e f10129a;

    C1454f(C1452e c1452e) {
        this.f10129a = c1452e;
    }

    /* renamed from: a */
    public void mo1849a() {
        if (this.f10129a.f10059d != null) {
            this.f10129a.f10059d.setText(C0247i.general__shared__downloading);
        }
    }

    /* renamed from: b */
    public void mo1851b() {
    }

    /* renamed from: c */
    public void mo1852c() {
        if (this.f10129a.f10059d != null) {
            this.f10129a.f10059d.setText(C0247i.general__shared__installed);
        }
    }

    /* renamed from: d */
    public void mo1853d() {
        if (this.f10129a.f10059d != null) {
            if (this.f10129a.f10057b.f2522g != 6 || this.f10129a.f10057b.f2538w == null || this.f10129a.f10057b.f2538w.isEmpty()) {
                this.f10129a.f10059d.setText(C0247i.general__shared__download);
            } else {
                this.f10129a.f10059d.setText(C0247i.general__shared__click_download);
            }
        }
    }

    /* renamed from: e */
    public void mo1854e() {
        if (this.f10129a.f10059d != null) {
            this.f10129a.f10059d.setText(C0247i.general__shared__install_start);
        }
    }

    /* renamed from: a */
    public void mo1850a(int i) {
    }
}
