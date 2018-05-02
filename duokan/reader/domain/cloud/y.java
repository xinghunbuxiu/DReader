package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.cloud.DkCloudStorage.ConflictStrategy;

class y implements u {
    final /* synthetic */ DkCloudReadingInfo a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ConflictStrategy c;
    final /* synthetic */ String d;
    final /* synthetic */ ar e;
    final /* synthetic */ DkCloudStorage f;

    y(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, boolean z, ConflictStrategy conflictStrategy, String str, ar arVar) {
        this.f = dkCloudStorage;
        this.a = dkCloudReadingInfo;
        this.b = z;
        this.c = conflictStrategy;
        this.d = str;
        this.e = arVar;
    }

    public void onQueryAccountOk(a aVar) {
        DkCloudReadingInfo dkCloudReadingInfo = new DkCloudReadingInfo(this.a.getCloudId(), this.a.getBookName(), this.a.getIsDuokanBook(), -1, this.a.getDeviceId(), this.a.getBookRevision(), this.a.getKernelVersion(), null, null);
        if (!this.b) {
            this.f.a(dkCloudReadingInfo, aVar, this.a, this.d, new z(this, dkCloudReadingInfo, aVar));
        } else if (this.a.getAnnotations() != null) {
            this.f.a(dkCloudReadingInfo, aVar, this.a, this.c, this.d, this.e);
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        this.e.a(this.a, str, this.d);
        this.e.b(this.a, str, this.d);
    }
}
