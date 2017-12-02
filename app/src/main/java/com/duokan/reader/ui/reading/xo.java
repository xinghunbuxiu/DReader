package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.domain.document.sbk.b;
import com.duokan.reader.domain.document.sbk.y;

class xo extends aaj {
    final /* synthetic */ xm a;

    private xo(xm xmVar) {
        this.a = xmVar;
        super(xmVar);
    }

    public boolean h() {
        return this.a.b;
    }

    public View a(Context context) {
        return this.a.c.bk().a(context);
    }

    public long a() {
        return (long) this.a.C().C();
    }

    public long a(ba baVar) {
        return ((y) baVar).c();
    }

    public long[] a(ak akVar) {
        if (!this.a.h.d((a) akVar) || !akVar.e()) {
            return new long[0];
        }
        if (((b) akVar.g()).g() == ((b) akVar.h()).g()) {
            return new long[]{((b) akVar.g()).g()};
        }
        return new long[]{((b) akVar.g()).g(), ((b) akVar.h()).g()};
    }

    public String a(long j) {
        return this.a.C().b(j);
    }

    public String b(long j) {
        g a = this.a.C().D().a(j);
        return a == null ? "" : a.e();
    }

    public boolean e(long j) {
        return !this.a.C().d(j);
    }

    public PageAnimationMode U() {
        if (this.a.f.r() == BookContent.VERTICAL_COMIC) {
            this.a.J = PageAnimationMode.VSCROLL;
        }
        return this.a.J;
    }

    public void a(PageAnimationMode pageAnimationMode) {
        this.a.J = pageAnimationMode;
    }

    public boolean aH() {
        return ((ReaderFeature) this.a.getContext().queryFeature(ReaderFeature.class)).inNightMode();
    }

    public ReadingTheme N() {
        return ReadingTheme.THEME19;
    }

    public void b(boolean z) {
    }

    public boolean h_() {
        return false;
    }

    public boolean ak() {
        return true;
    }

    public boolean g() {
        return false;
    }

    public int j_() {
        return Q();
    }

    public void onItemChanged(an anVar, int i) {
        super.onItemChanged(anVar, i);
        if (anVar == this.a.f) {
            b(new xp(this, i));
        }
    }
}
