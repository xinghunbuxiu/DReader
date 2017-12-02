package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.sbk.t;
import com.duokan.reader.ui.general.gh;

public class xw extends fs {
    final /* synthetic */ xt d;

    public xw(xt xtVar, a aVar) {
        this.d = xtVar;
        super(xtVar, aVar);
    }

    public gh a(int i) {
        if (!this.d.a.h()) {
            return super.a(i);
        }
        if (this.d.d) {
            this.d.b = null;
            this.d.c = -1;
            return super.a(i);
        } else if (this.d.b == null) {
            if (i == this.d.getMaxPageOffset() && (this.a instanceof t) && this.a.b()) {
                a aVar = (t) b(i);
                this.d.a.getDocument().d(aVar);
                if (aVar.e() && ((t) this.a).j().g() != aVar.j().g() && ((t) this.a).j().h() > 0) {
                    View a = this.d.a.a(this.d.getContext());
                    if (a != null) {
                        gh xvVar = new xv(this.d, b(i), a);
                        this.d.b = a;
                        this.d.c = this.d.b(i);
                        return xvVar;
                    }
                }
            }
            return super.a(i);
        } else {
            int c = this.d.b_(this.d.c);
            if (c >= 0) {
                if (i < c) {
                    return super.a(i);
                }
                if (i > c) {
                    return super.a(i - 1);
                }
                return new xv(this.d, b(i), this.d.b);
            } else if (i > c) {
                return super.a(i);
            } else {
                if (i < c) {
                    return super.a(i + 1);
                }
                return new xv(this.d, b(i), this.d.b);
            }
        }
    }
}
