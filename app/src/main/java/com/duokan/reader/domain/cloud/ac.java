package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.bookshelf.ju;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

class ac implements u {
    final /* synthetic */ DkCloudReadingInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ ju c;
    final /* synthetic */ String d;
    final /* synthetic */ as e;
    final /* synthetic */ ConflictStrategy f;
    final /* synthetic */ DkCloudStorage g;

    ac(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, int i, ju juVar, String str, as asVar, ConflictStrategy conflictStrategy) {
        this.g = dkCloudStorage;
        this.a = dkCloudReadingInfo;
        this.b = i;
        this.c = juVar;
        this.d = str;
        this.e = asVar;
        this.f = conflictStrategy;
    }

    public void onQueryAccountOk(a aVar) {
        DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.a.getCloudId(), this.a.getBookName(), this.a.getIsDuokanBook(), -1, this.a.getDeviceId(), this.a.getBookRevision(), this.a.getKernelVersion(), null, null);
        if (this.a.getReadingProgress() != null) {
            this.g.a(this.b, this.c, dkCloudReadingInfo, aVar, this.a, this.d, new ad(this, aVar));
        } else if (this.a.getAnnotations() != null) {
            this.g.a(dkCloudReadingInfo, aVar, this.a, this.f, this.d, this.e);
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        this.e.a(this.a, str, this.d);
        this.e.b(this.a, str, this.d);
    }
}
