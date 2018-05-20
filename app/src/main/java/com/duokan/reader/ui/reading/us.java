package com.duokan.reader.ui.reading;

import com.duokan.reader.common.webservices.duokan.C0650x;

class us implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ur f11031a;

    us(ur urVar) {
        this.f11031a = urVar;
    }

    public void run() {
        String I = this.f11031a.f11029a.getId();
        if (this.f11031a.f11029a.al()) {
            I = new C0650x(this.f11031a.f11029a.getId()).m3046a();
        }
        su a = this.f11031a.f11030b.f11020a;
        int i = this.f11031a.f11029a.al() ? 4 : this.f11031a.f11029a.mo1038k() ? 2 : 1;
        a.mo2037a(I, i);
    }
}
