package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0672a;

class aa implements al {
    /* renamed from: a */
    static final /* synthetic */ boolean f3642a = (!DkCloudStorage.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0672a f3643b;
    /* renamed from: c */
    final /* synthetic */ C0891z f3644c;

    aa(C0891z c0891z, C0672a c0672a) {
        this.f3644c = c0891z;
        this.f3643b = c0672a;
    }

    /* renamed from: a */
    public void mo1112a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.f3644c.f4216e.mo1112a(dkCloudReadingInfo, dkCloudReadingInfo2, str);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.f3644c.f4218g.m4999a(dkCloudReadingInfo2, this.f3643b, dkCloudReadingInfo, this.f3644c.f4217f, str, this.f3644c.f4216e);
        }
    }

    /* renamed from: a */
    public void mo1113a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.f3644c.f4216e.mo1113a(dkCloudReadingInfo, str, str2);
        this.f3644c.f4216e.mo1115b(dkCloudReadingInfo, str, str2);
    }

    /* renamed from: b */
    public void mo1114b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (!f3642a) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1115b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        if (!f3642a) {
            throw new AssertionError();
        }
    }
}
