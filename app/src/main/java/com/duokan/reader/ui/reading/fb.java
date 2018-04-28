package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.p044b.C0792m;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

class fb implements Comparator<C0792m> {
    /* renamed from: a */
    final /* synthetic */ ex f10131a;
    /* renamed from: b */
    private Collator f10132b = Collator.getInstance(Locale.CHINESE);

    fb(ex exVar) {
        this.f10131a = exVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m14049a((C0792m) obj, (C0792m) obj2);
    }

    /* renamed from: a */
    public int m14049a(C0792m c0792m, C0792m c0792m2) {
        int i = 1;
        if (c0792m.m3699c() == c0792m2.m3699c()) {
            return this.f10132b.compare(c0792m.mo947a(), c0792m2.mo947a());
        }
        if (!this.f10131a.f10116a) {
            if (!c0792m.m3699c()) {
                i = -1;
            }
            return i;
        } else if (c0792m.m3699c()) {
            return -1;
        } else {
            return 1;
        }
    }
}
