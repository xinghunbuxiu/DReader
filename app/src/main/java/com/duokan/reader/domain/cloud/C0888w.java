package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.w */
class C0888w implements ak {
    /* renamed from: a */
    static final /* synthetic */ boolean f4202a = (!DkCloudStorage.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ DkCloudReadingInfo f4203b;
    /* renamed from: c */
    final /* synthetic */ C0672a f4204c;
    /* renamed from: d */
    final /* synthetic */ C0887v f4205d;

    C0888w(C0887v c0887v, DkCloudReadingInfo dkCloudReadingInfo, C0672a c0672a) {
        this.f4205d = c0887v;
        this.f4203b = dkCloudReadingInfo;
        this.f4204c = c0672a;
    }

    /* renamed from: a */
    public void mo1084a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.f4205d.f4200e.mo1084a(dkCloudReadingInfo, dkCloudReadingInfo2, str);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.f4205d.f4201f.m4998a(this.f4203b, this.f4204c, dkCloudReadingInfo, this.f4205d.f4198c, str, this.f4205d.f4200e);
        }
    }

    /* renamed from: a */
    public void mo1085a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.f4205d.f4200e.mo1085a(dkCloudReadingInfo, str, str2);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.f4205d.f4201f.m4998a(this.f4203b, this.f4204c, dkCloudReadingInfo, this.f4205d.f4198c, str2, this.f4205d.f4200e);
        }
    }

    /* renamed from: b */
    public void mo1086b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (!f4202a) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public void mo1087b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        if (!f4202a) {
            throw new AssertionError();
        }
    }
}
