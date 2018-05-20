package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;

/* renamed from: com.duokan.reader.ui.store.z */
class C1513z implements ah {
    /* renamed from: a */
    final /* synthetic */ C1512y f11490a;

    C1513z(C1512y c1512y) {
        this.f11490a = c1512y;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.f11490a.f11489a.f11488d.f11462g.remove(this.f11490a.f11489a.f11485a.getId());
        ((fp) this.f11490a.f11489a.f11485a).m4481a(dkCloudBookManifest, this.f11490a.f11489a.f11486b.wifiOnly());
        this.f11490a.f11489a.f11487c.mo1047a(str, dkCloudBookManifest);
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        this.f11490a.f11489a.f11488d.f11462g.remove(this.f11490a.f11489a.f11485a.getId());
        this.f11490a.f11489a.f11487c.mo1048a(str, str2);
    }
}
