package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.micloud.bi;

public class is {
    /* renamed from: a */
    private final bi f3354a;
    /* renamed from: b */
    private String f3355b;
    /* renamed from: c */
    private boolean f3356c = false;

    public is(bi biVar) {
        this.f3354a = biVar;
    }

    /* renamed from: a */
    public bi m4680a() {
        return this.f3354a;
    }

    /* renamed from: b */
    public String m4682b() {
        return this.f3354a.m8155e();
    }

    /* renamed from: c */
    public long m4683c() {
        return this.f3354a.m8158h();
    }

    /* renamed from: d */
    public long m4684d() {
        return this.f3354a.m8160j();
    }

    /* renamed from: e */
    public String m4685e() {
        return this.f3354a.m8161k();
    }

    /* renamed from: f */
    public String m4686f() {
        if (TextUtils.isEmpty(this.f3355b)) {
            this.f3355b = ae.m3786a(this.f3354a);
        }
        return this.f3355b;
    }

    /* renamed from: g */
    public void m4687g() {
        m4686f();
    }

    /* renamed from: h */
    public boolean m4688h() {
        return this.f3356c;
    }

    /* renamed from: a */
    public void m4681a(boolean z) {
        this.f3356c = z;
    }
}
