package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.al;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.em;

class mt implements al {
    /* renamed from: a */
    final /* synthetic */ em f8965a;
    /* renamed from: b */
    final /* synthetic */ int f8966b;
    /* renamed from: c */
    final /* synthetic */ mj f8967c;

    mt(mj mjVar, em emVar, int i) {
        this.f8967c = mjVar;
        this.f8965a = emVar;
        this.f8966b = i;
    }

    /* renamed from: a */
    public void mo1112a(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
    }

    /* renamed from: a */
    public void mo1113a(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
    }

    /* renamed from: b */
    public void mo1114b(DkCloudReadingInfo dkCloudReadingInfo, DkCloudReadingInfo dkCloudReadingInfo2, String str) {
        this.f8967c.f8951a.f8945g = dkCloudReadingInfo2;
        this.f8965a.dismiss();
        this.f8967c.c.m9954a();
    }

    /* renamed from: b */
    public void mo1115b(DkCloudReadingInfo dkCloudReadingInfo, String str, String str2) {
        this.f8965a.dismiss();
        this.f8967c.f8951a.f8945g = dkCloudReadingInfo;
        if (TextUtils.isEmpty(str)) {
            be.m10286a(this.f8967c.getContext(), this.f8966b, 0).show();
        } else {
            be.m10287a(this.f8967c.getContext(), (CharSequence) str, 0).show();
        }
        this.f8967c.c.m9954a();
    }
}
