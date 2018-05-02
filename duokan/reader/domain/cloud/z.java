package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;

class z implements ar {
    static final /* synthetic */ boolean a = (!DkCloudStorage.class.desiredAssertionStatus());
    final /* synthetic */ DkCloudReadingInfo b;
    final /* synthetic */ a c;
    final /* synthetic */ y d;

    z(y yVar, DkCloudReadingInfo dkCloudReadingInfo, a aVar) {
        this.d = yVar;
        this.b = dkCloudReadingInfo;
        this.c = aVar;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.d.e.a(dkCloudReadingInfo, dkCloudReadingInfo2, str);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.d.f.a(this.b, this.c, dkCloudReadingInfo, this.d.c, str, this.d.e);
        }
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.d.e.a(dkCloudReadingInfo, str, str2);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.d.f.a(this.b, this.c, dkCloudReadingInfo, this.d.c, str2, this.d.e);
        }
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        if (!a) {
            throw new AssertionError();
        }
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        if (!a) {
            throw new AssertionError();
        }
    }
}
