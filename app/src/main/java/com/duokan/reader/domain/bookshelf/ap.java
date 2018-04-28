package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.core.sys.af;

public class ap<V, R> extends af<V> {
    /* renamed from: a */
    private R f2770a;

    protected ap() {
    }

    /* renamed from: a */
    public void mo975a(V v) {
        super.mo975a((Object) v);
        this.f2770a = null;
    }

    /* renamed from: d */
    public boolean m4013d() {
        boolean z = true;
        if (!(this.f2770a instanceof String)) {
            if (this.f2770a == null) {
                z = false;
            }
            return z;
        } else if (TextUtils.isEmpty((String) this.f2770a)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: e */
    public R m4014e() {
        return this.f2770a;
    }

    /* renamed from: c */
    public void m4012c(R r) {
        this.f2770a = r;
    }
}
