package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class aa implements u {
    final /* synthetic */ DkCloudReadingInfo a;
    final /* synthetic */ DkCloudAnnotation[] b;
    final /* synthetic */ String c;
    final /* synthetic */ as d;
    final /* synthetic */ DkCloudStorage e;

    aa(DkCloudStorage dkCloudStorage, DkCloudReadingInfo dkCloudReadingInfo, DkCloudAnnotation[] dkCloudAnnotationArr, String str, as asVar) {
        this.e = dkCloudStorage;
        this.a = dkCloudReadingInfo;
        this.b = dkCloudAnnotationArr;
        this.c = str;
        this.d = asVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.e.a(new DkCloudReadingInfo(this.a.getCloudId(), this.a.getBookName(), this.a.getIsDuokanBook(), -1, this.a.getDeviceId(), this.a.getBookRevision(), this.a.getKernelVersion(), null, null), aVar, this.a, this.b, this.c, new ab(this));
    }

    public void onQueryAccountError(a aVar, String str) {
        this.d.b(this.a, str, this.c);
    }
}
