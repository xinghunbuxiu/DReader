package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.sbk.C0965b;
import com.duokan.reader.domain.document.sbk.C0983y;

class yb extends aaw {
    /* renamed from: a */
    final /* synthetic */ xz f11182a;

    private yb(xz xzVar) {
        this.f11182a = xzVar;
        super(xzVar);
    }

    /* renamed from: h */
    public boolean mo2155h() {
        return this.f11182a.f11172b;
    }

    /* renamed from: a */
    public View mo2014a(Context context) {
        return this.f11182a.c.bl().m12754a(context);
    }

    /* renamed from: a */
    public long mo2354a() {
        return (long) this.f11182a.m15076C().m7180C();
    }

    /* renamed from: a */
    public long mo2355a(ba baVar) {
        return ((C0983y) baVar).m7325c();
    }

    /* renamed from: a */
    public long[] mo2358a(ak akVar) {
        if (!this.f11182a.h.mo1233d((C0896a) akVar) || !akVar.mo1192e()) {
            return new long[0];
        }
        if (((C0965b) akVar.mo1198g()).m7141g() == ((C0965b) akVar.mo1199h()).m7141g()) {
            return new long[]{((C0965b) akVar.mo1198g()).m7141g()};
        }
        return new long[]{((C0965b) akVar.mo1198g()).m7141g(), ((C0965b) akVar.mo1199h()).m7141g()};
    }

    /* renamed from: a */
    public String mo2356a(long j) {
        return this.f11182a.m15076C().m7200b(j);
    }

    /* renamed from: b */
    public String mo2359b(long j) {
        C0901g a = this.f11182a.m15076C().m7181D().mo1452a(j);
        return a == null ? "" : a.mo1202e();
    }

    /* renamed from: e */
    public boolean mo2361e(long j) {
        return !this.f11182a.m15076C().m7211d(j);
    }

    /* renamed from: U */
    public PageAnimationMode mo2004U() {
        if (this.f11182a.f.m4246r() == BookContent.VERTICAL_COMIC) {
            this.f11182a.f11171J = PageAnimationMode.VSCROLL;
        }
        return this.f11182a.f11171J;
    }

    /* renamed from: a */
    public void mo2030a(PageAnimationMode pageAnimationMode) {
        this.f11182a.f11171J = pageAnimationMode;
    }

    public boolean aH() {
        return ((ReaderFeature) this.f11182a.getContext().queryFeature(ReaderFeature.class)).inNightMode();
    }

    /* renamed from: N */
    public ReadingTheme mo1997N() {
        return ReadingTheme.THEME19;
    }

    /* renamed from: b */
    public void mo2105b(boolean z) {
    }

    public boolean i_() {
        return false;
    }

    public boolean ak() {
        return true;
    }

    /* renamed from: g */
    public boolean mo2145g() {
        return false;
    }

    public int k_() {
        return mo2000Q();
    }

    public void onItemChanged(an anVar, int i) {
        super.onItemChanged(anVar, i);
        if (anVar == this.f11182a.f) {
            mo2103b(new yc(this, i));
        }
    }
}
