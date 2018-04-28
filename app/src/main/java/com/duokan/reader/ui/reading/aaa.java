package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.aj;
import com.duokan.reader.ui.general.be;

class aaa implements aj {
    /* renamed from: a */
    final /* synthetic */ zx f9260a;

    aaa(zx zxVar) {
        this.f9260a = zxVar;
    }

    /* renamed from: a */
    public void mo1974a() {
        be.m10286a(this.f9260a.getContext(), C0258j.reading__send_error_view__thx, 1).show();
        this.f9260a.requestBack();
    }

    /* renamed from: a */
    public void mo1975a(String str) {
        this.f9260a.f11287f.setEnabled(true);
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f9260a.getContext(), (CharSequence) str, 1).show();
        }
        this.f9260a.requestBack();
    }
}
