package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.be;

class ki implements ao {
    final /* synthetic */ c a;
    final /* synthetic */ kh b;

    ki(kh khVar, c cVar) {
        this.b = khVar;
        this.a = cVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (this.a == this.b.b.get(this.b.b.size() - 1) && this.b.c != null) {
            this.b.c.run();
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.a(this.b.d.getContext(), (CharSequence) str2, 1).show();
        }
        if (this.a == this.b.b.get(this.b.b.size() - 1) && this.b.c != null) {
            this.b.c.run();
        }
    }
}
