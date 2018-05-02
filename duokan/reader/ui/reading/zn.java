package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.domain.cloud.aq;
import com.duokan.reader.ui.general.be;

class zn implements aq {
    final /* synthetic */ zk a;

    zn(zk zkVar) {
        this.a = zkVar;
    }

    public void a() {
        be.a(this.a.getContext(), j.reading__send_error_view__thx, 1).show();
        this.a.requestBack();
    }

    public void a(String str) {
        this.a.f.setEnabled(true);
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.getContext(), (CharSequence) str, 1).show();
        }
        this.a.requestBack();
    }
}
