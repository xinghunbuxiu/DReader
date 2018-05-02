package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.be;

class jy implements ao {
    final /* synthetic */ jx a;

    jy(jx jxVar) {
        this.a = jxVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        if (this.a.a.e == this.a.b) {
            this.a.a.d.setEnabled(true);
            this.a.a.b();
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.a(DkApp.get(), (CharSequence) str2, 1).show();
        }
        if (this.a.a.e == this.a.b) {
            this.a.a.d.setEnabled(true);
            this.a.a.b();
        }
    }
}
