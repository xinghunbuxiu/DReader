package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.bookshelf.kg;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

/* renamed from: com.duokan.reader.domain.cloud.z */
class C0891z implements C0666x {
    /* renamed from: a */
    final /* synthetic */ DkCloudReadingInfo f4212a;
    /* renamed from: b */
    final /* synthetic */ int f4213b;
    /* renamed from: c */
    final /* synthetic */ kg f4214c;
    /* renamed from: d */
    final /* synthetic */ String f4215d;
    /* renamed from: e */
    final /* synthetic */ al f4216e;
    /* renamed from: f */
    final /* synthetic */ ConflictStrategy f4217f;
    /* renamed from: g */
    final /* synthetic */ DkCloudStorage f4218g;

    C0891z(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, int i, kg kgVar, String str, al alVar, ConflictStrategy conflictStrategy) {
        this.f4218g = dkCloudStorage;
        this.f4212a = dkCloudReadingInfo;
        this.f4213b = i;
        this.f4214c = kgVar;
        this.f4215d = str;
        this.f4216e = alVar;
        this.f4217f = conflictStrategy;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.f4212a.getCloudId(), this.f4212a.getBookName(), this.f4212a.getIsDuokanBook(), -1, this.f4212a.getDeviceId(), this.f4212a.getBookRevision(), this.f4212a.getKernelVersion(), null, null);
        if (this.f4212a.getReadingProgress() != null) {
            this.f4218g.m4995a(this.f4213b, this.f4214c, dkCloudReadingInfo, c0672a, this.f4212a, this.f4215d, new aa(this, c0672a));
        } else if (this.f4212a.getAnnotations() != null) {
            this.f4218g.m4999a(dkCloudReadingInfo, c0672a, this.f4212a, this.f4217f, this.f4215d, this.f4216e);
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f4216e.mo1113a(this.f4212a, str, this.f4215d);
        this.f4216e.mo1115b(this.f4212a, str, this.f4215d);
    }
}
