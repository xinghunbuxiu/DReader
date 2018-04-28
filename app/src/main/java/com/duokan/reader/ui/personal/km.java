package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.be;

class km implements ah {
    /* renamed from: a */
    final /* synthetic */ kl f8819a;

    km(kl klVar) {
        this.f8819a = klVar;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (this.f8819a.f8816a.f8227e == this.f8819a.f8817b) {
            this.f8819a.f8816a.f8226d.setEnabled(true);
            this.f8819a.f8816a.m11363b();
        }
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(DkApp.get(), (CharSequence) str2, 1).show();
        }
        if (this.f8819a.f8816a.f8227e == this.f8819a.f8817b) {
            this.f8819a.f8816a.f8226d.setEnabled(true);
            this.f8819a.f8816a.m11363b();
        }
    }
}
