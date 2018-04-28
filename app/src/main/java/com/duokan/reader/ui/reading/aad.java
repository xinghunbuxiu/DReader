package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.reader.ui.store.an;
import java.util.Arrays;

class aad implements an {
    /* renamed from: a */
    final /* synthetic */ aac f9323a;

    aad(aac aac) {
        this.f9323a = aac;
    }

    /* renamed from: a */
    public void mo1982a(String str, String str2) {
        C0328a.m757c().m749a(LogLevel.EVENT, "autopay", "pay-ok(book: %s(%s), chapter: %s(%d|%s))", this.f9323a.f9316d, str, this.f9323a.f9318f, Long.valueOf(this.f9323a.f9314b), str2);
        this.f9323a.f9322j.f9311a.put(str2, new af(Integer.valueOf(0)));
        aab aab = this.f9323a.f9322j;
        aab.E++;
        aab = this.f9323a.f9322j;
        aab.F += this.f9323a.f9320h;
        this.f9323a.f9322j.m12873b(Arrays.asList(new String[]{str2}), new aae(this));
    }

    /* renamed from: a */
    public void mo1983a(String str, String str2, Integer num) {
        C0328a.m757c().m749a(LogLevel.EVENT, "autopay", "pay-error: %d(book: %s(%s), chapter: %s(%d|%s))", num, this.f9323a.f9316d, str, this.f9323a.f9318f, Long.valueOf(this.f9323a.f9314b), str2);
        if (num != null) {
            this.f9323a.f9322j.f9311a.put(str2, new af(num));
        } else {
            this.f9323a.f9322j.f9311a.put(str2, new af(Integer.valueOf(-1)));
        }
        if (this.f9323a.f9313a != null) {
            this.f9323a.f9313a.mo2157i(false);
        }
        UThread.post(this.f9323a.f9321i);
    }
}
