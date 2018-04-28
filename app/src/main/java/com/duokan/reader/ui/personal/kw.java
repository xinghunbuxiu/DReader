package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.be;

class kw implements ah {
    /* renamed from: a */
    final /* synthetic */ C0800c f8840a;
    /* renamed from: b */
    final /* synthetic */ kv f8841b;

    kw(kv kvVar, C0800c c0800c) {
        this.f8841b = kvVar;
        this.f8840a = c0800c;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (this.f8840a == this.f8841b.f8837b.get(this.f8841b.f8837b.size() - 1) && this.f8841b.f8838c != null) {
            this.f8841b.f8838c.run();
        }
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(this.f8841b.f8839d.getContext(), (CharSequence) str2, 1).show();
        }
        if (this.f8840a == this.f8841b.f8837b.get(this.f8841b.f8837b.size() - 1) && this.f8841b.f8838c != null) {
            this.f8841b.f8838c.run();
        }
    }
}
