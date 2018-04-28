package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.epub.ay;
import com.duokan.reader.ui.general.gb;

public class ix extends fx {
    /* renamed from: d */
    final /* synthetic */ it f10409d;

    public ix(it itVar, C0896a c0896a) {
        this.f10409d = itVar;
        super(itVar, c0896a);
    }

    /* renamed from: a */
    public gb mo2324a(int i) {
        if (this.f10409d.f10404a.mo2155h() && i == 1) {
            Object obj;
            this.f10409d.f10407d = 1 + this.f10409d.f10407d;
            ee eeVar = (ee) this.f10409d.f10404a.mo1992G();
            C0903n document = this.f10409d.f10404a.getDocument();
            long round = (long) Math.round((float) ((Math.max(this.f10409d.f10405b - 2, 1) * 60) * 1000));
            long max = (long) ((Math.max(this.f10409d.f10405b, 1) * 60) * 1000);
            long currentTimeMillis = System.currentTimeMillis() - this.f10409d.f10406c;
            if (this.f10409d.f10407d <= 5) {
                obj = null;
            } else if (eeVar.m4242o() == BookType.SERIAL) {
                if (currentTimeMillis < round) {
                    obj = null;
                } else {
                    r2 = document.m5896a(this.a);
                    document.mo1233d(r2);
                    if (r2.mo1187a(500)) {
                        round = ((ay) r2).m6533k().m6780g();
                        if (((hy) this.f10409d.f10404a).mo2194g(round) != (short) 0) {
                            obj = null;
                        } else if (currentTimeMillis < max) {
                            r1 = document.mo1237f(r2);
                            document.mo1233d(r1);
                            obj = r1.mo1187a(200) ? round != ((ay) r1).m6533k().m6780g() ? 1 : null : null;
                        } else {
                            obj = 1;
                        }
                    } else {
                        obj = null;
                    }
                }
            } else if (currentTimeMillis < round) {
                obj = null;
            } else if (currentTimeMillis < max) {
                r1 = document.m5896a(this.a);
                r2 = document.mo1237f(r1);
                document.mo1233d(r1);
                document.mo1233d(r2);
                obj = (r1.mo1187a(200) && r2.mo1187a(200)) ? ((ay) r1).m6533k().m6780g() != ((ay) r2).m6533k().m6780g() ? 1 : null : null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f10409d.f10405b = eeVar.bg();
                this.f10409d.f10406c = System.currentTimeMillis();
                this.f10409d.f10407d = 0;
                View a = this.f10409d.f10404a.mo2014a(this.f10409d.getContext());
                if (a != null) {
                    gb ivVar = new iv(this.f10409d, m14154b(i), null, a);
                    if (ivVar != null) {
                        return ivVar;
                    }
                }
            }
        }
        return super.mo2324a(i);
    }
}
