package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.core.sys.af;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;

class gg implements ah {
    /* renamed from: a */
    final /* synthetic */ gf f3226a;

    gg(gf gfVar) {
        this.f3226a = gfVar;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (!this.f3226a.f3225b.aZ()) {
            this.f3226a.f3225b.m4481a(dkCloudBookManifest, new af(Boolean.valueOf(true)));
        }
        UThread.post(this.f3226a.f3224a);
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        this.f3226a.f3225b.m4471b(this.f3226a.f3224a);
    }
}
