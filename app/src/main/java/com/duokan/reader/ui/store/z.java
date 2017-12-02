package com.duokan.reader.ui.store;

import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;

class z implements ao {
    final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.a.a.d.g.remove(this.a.a.a.H());
        ((fv) this.a.a.a).a(dkCloudBookManifest, this.a.a.b.wifiOnly());
        this.a.a.c.a(str, dkCloudBookManifest);
    }

    public void a(String str, String str2) {
        this.a.a.d.g.remove(this.a.a.a.H());
        this.a.a.c.a(str, str2);
    }
}
