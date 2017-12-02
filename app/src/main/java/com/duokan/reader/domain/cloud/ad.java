package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;

class ad implements as {
    static final /* synthetic */ boolean a = (!DkCloudStorage.class.desiredAssertionStatus());
    final /* synthetic */ a b;
    final /* synthetic */ ac c;

    ad(ac acVar, a aVar) {
        this.c = acVar;
        this.b = aVar;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.c.e.a(dkCloudReadingInfo, dkCloudReadingInfo2, str);
        if (dkCloudReadingInfo.getAnnotations() != null) {
            this.c.g.a(dkCloudReadingInfo2, this.b, dkCloudReadingInfo, this.c.f, str, this.c.e);
        }
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.c.e.a(dkCloudReadingInfo, str, str2);
        this.c.e.b(dkCloudReadingInfo, str, str2);
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
