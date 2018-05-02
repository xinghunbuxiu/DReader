package com.duokan.reader.domain.document.txt;

import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;

/* renamed from: com.duokan.reader.domain.document.txt.d */
public class C0988d extends C0901g {
    /* renamed from: a */
    private final C1000p f4937a;
    /* renamed from: b */
    private final int f4938b;
    /* renamed from: c */
    private final int f4939c;
    /* renamed from: d */
    private final String f4940d;
    /* renamed from: e */
    private final av f4941e;
    /* renamed from: f */
    private ak f4942f = null;

    protected C0988d(C1000p c1000p, int i, int i2, String str, av avVar) {
        this.f4937a = c1000p;
        this.f4938b = i;
        this.f4939c = i2;
        this.f4940d = str;
        this.f4941e = avVar;
    }

    /* renamed from: d */
    public int mo1201d() {
        return this.f4938b;
    }

    /* renamed from: c */
    public int mo1200c() {
        return this.f4939c;
    }

    /* renamed from: e */
    public String mo1202e() {
        return this.f4940d;
    }

    /* renamed from: f */
    public av mo1203f() {
        return this.f4941e;
    }

    /* renamed from: g */
    public ak mo1204g() {
        if (this.f4942f == null || !this.f4942f.mo1186a()) {
            this.f4942f = this.f4937a.m7729d(this.f4941e);
        }
        return this.f4942f;
    }

    /* renamed from: h */
    public int mo1205h() {
        return 0;
    }

    /* renamed from: i */
    public int mo1206i() {
        return 0;
    }

    /* renamed from: j */
    public C0901g[] mo1207j() {
        return new C0988d[0];
    }

    /* renamed from: k */
    public boolean mo1208k() {
        return true;
    }
}
