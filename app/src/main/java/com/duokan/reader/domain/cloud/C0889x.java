package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.cloud.x */
class C0889x implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkCloudReadingInfo f4206a;
    /* renamed from: b */
    final /* synthetic */ DkCloudAnnotation[] f4207b;
    /* renamed from: c */
    final /* synthetic */ String f4208c;
    /* renamed from: d */
    final /* synthetic */ al f4209d;
    /* renamed from: e */
    final /* synthetic */ DkCloudStorage f4210e;

    C0889x(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, DkCloudAnnotation[] dkCloudAnnotationArr, String str, al alVar) {
        this.f4210e = dkCloudStorage;
        this.f4206a = dkCloudReadingInfo;
        this.f4207b = dkCloudAnnotationArr;
        this.f4208c = str;
        this.f4209d = alVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f4210e.m5001a(new DkCloudReadingInfo(this.f4206a.getCloudId(), this.f4206a.getBookName(), this.f4206a.getIsDuokanBook(), -1, this.f4206a.getDeviceId(), this.f4206a.getBookRevision(), this.f4206a.getKernelVersion(), null, null), c0672a, this.f4206a, this.f4207b, this.f4208c, new C0890y(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4209d.mo1115b(this.f4206a, str, this.f4208c);
    }
}
