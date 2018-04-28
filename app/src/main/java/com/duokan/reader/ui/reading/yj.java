package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.sbk.C0979t;
import com.duokan.reader.ui.general.gb;

public class yj extends fx {
    /* renamed from: d */
    final /* synthetic */ yg f11192d;

    public yj(yg ygVar, C0896a c0896a) {
        this.f11192d = ygVar;
        super(ygVar, c0896a);
    }

    /* renamed from: a */
    public gb mo2324a(int i) {
        if (!this.f11192d.f11188a.mo2155h()) {
            return super.mo2324a(i);
        }
        if (this.f11192d.f11191d) {
            this.f11192d.f11189b = null;
            this.f11192d.f11190c = -1;
            return super.mo2324a(i);
        } else if (this.f11192d.f11189b == null) {
            if (i == this.f11192d.getMaxPageOffset() && (this.a instanceof C0979t) && this.a.m5777b()) {
                C0896a c0896a = (C0979t) m14154b(i);
                this.f11192d.f11188a.getDocument().mo1233d(c0896a);
                if (c0896a.mo1192e() && ((C0979t) this.a).mo1454j().m7141g() != c0896a.mo1454j().m7141g() && ((C0979t) this.a).mo1454j().m7142h() > 0) {
                    View a = this.f11192d.f11188a.mo2014a(this.f11192d.getContext());
                    if (a != null) {
                        gb yiVar = new yi(this.f11192d, m14154b(i), a);
                        this.f11192d.f11189b = a;
                        this.f11192d.f11190c = this.f11192d.m10127b(i);
                        return yiVar;
                    }
                }
            }
            return super.mo2324a(i);
        } else {
            int c = this.f11192d.b_(this.f11192d.f11190c);
            if (c >= 0) {
                if (i < c) {
                    return super.mo2324a(i);
                }
                if (i > c) {
                    return super.mo2324a(i - 1);
                }
                return new yi(this.f11192d, m14154b(i), this.f11192d.f11189b);
            } else if (i > c) {
                return super.mo2324a(i);
            } else {
                if (i < c) {
                    return super.mo2324a(i + 1);
                }
                return new yi(this.f11192d, m14154b(i), this.f11192d.f11189b);
            }
        }
    }
}
