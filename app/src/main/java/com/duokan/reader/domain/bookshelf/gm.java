package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.af;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;

class gm implements ao {
    final /* synthetic */ gl a;

    gm(gl glVar) {
        this.a = glVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (!this.a.b.aX()) {
            this.a.b.a(dkCloudBookManifest, new af(Boolean.valueOf(true)));
        }
        t.b(this.a.a);
    }

    public void a(String str, String str2) {
        this.a.b.b(this.a.a);
    }
}
