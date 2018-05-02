package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.reading.h */
class C1456h implements im {
    /* renamed from: a */
    final /* synthetic */ C1455g f10309a;

    C1456h(C1455g c1455g) {
        this.f10309a = c1455g;
    }

    /* renamed from: a */
    public void mo1021a(C0800c c0800c) {
        this.f10309a.f10216k = this.f10309a.f10206a.getResources().getString(C0247i.reading__shared__add_to_bookshelf_done);
        this.f10309a.f10217l = true;
        this.f10309a.f10215j = new AlphaAnimation(((float) this.f10309a.f10210e.getAlpha()) / 255.0f, 0.0f);
        this.f10309a.f10215j.setAnimationListener(new C1457i(this));
        this.f10309a.f10215j.setDuration(500);
        this.f10309a.f10215j.setInterpolator(new LinearInterpolator());
        this.f10309a.invalidateSelf();
    }

    /* renamed from: a */
    public void mo1022a(String str) {
        be.m10287a(this.f10309a.f10206a, (CharSequence) str, 0).show();
    }
}
