package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

/* renamed from: com.duokan.reader.domain.cloud.v */
class C0887v implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkCloudReadingInfo f4196a;
    /* renamed from: b */
    final /* synthetic */ boolean f4197b;
    /* renamed from: c */
    final /* synthetic */ ConflictStrategy f4198c;
    /* renamed from: d */
    final /* synthetic */ String f4199d;
    /* renamed from: e */
    final /* synthetic */ ak f4200e;
    /* renamed from: f */
    final /* synthetic */ DkCloudStorage f4201f;

    C0887v(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, boolean z, ConflictStrategy conflictStrategy, String str, ak akVar) {
        this.f4201f = dkCloudStorage;
        this.f4196a = dkCloudReadingInfo;
        this.f4197b = z;
        this.f4198c = conflictStrategy;
        this.f4199d = str;
        this.f4200e = akVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.f4196a.getCloudId(), this.f4196a.getBookName(), this.f4196a.getIsDuokanBook(), -1, this.f4196a.getDeviceId(), this.f4196a.getBookRevision(), this.f4196a.getKernelVersion(), null, null);
        if (!this.f4197b) {
            this.f4201f.m5000a(dkCloudReadingInfo, c0672a, this.f4196a, this.f4199d, new C0888w(this, dkCloudReadingInfo, c0672a));
        } else if (this.f4196a.getAnnotations() != null) {
            this.f4201f.m4998a(dkCloudReadingInfo, c0672a, this.f4196a, this.f4198c, this.f4199d, this.f4200e);
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4200e.mo1085a(this.f4196a, str, this.f4199d);
        this.f4200e.mo1087b(this.f4196a, str, this.f4199d);
    }
}
