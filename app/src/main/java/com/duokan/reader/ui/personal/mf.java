package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.as;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.eo;

class mf implements as {
    final /* synthetic */ eo a;
    final /* synthetic */ int b;
    final /* synthetic */ lv c;

    mf(lv lvVar, eo eoVar, int i) {
        this.c = lvVar;
        this.a = eoVar;
        this.b = i;
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
    }

    public void a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.c.a.g = dkCloudReadingInfo2;
        this.a.dismiss();
        this.c.c.a();
    }

    public void b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.a.dismiss();
        this.c.a.g = dkCloudReadingInfo;
        if (TextUtils.isEmpty(str)) {
            be.a(this.c.getContext(), this.b, 0).show();
        } else {
            be.a(this.c.getContext(), (CharSequence) str, 0).show();
        }
        this.c.c.a();
    }
}
