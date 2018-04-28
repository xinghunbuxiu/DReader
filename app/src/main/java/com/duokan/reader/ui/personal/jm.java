package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.core.ui.C0342j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.ag;
import com.duokan.reader.ui.general.be;

class jm implements ag {
    /* renamed from: a */
    final /* synthetic */ C0342j f8784a;
    /* renamed from: b */
    final /* synthetic */ jl f8785b;

    jm(jl jlVar, C0342j c0342j) {
        this.f8785b = jlVar;
        this.f8784a = c0342j;
    }

    /* renamed from: a */
    public void mo1184a(boolean z) {
        if (this.f8784a != null) {
            this.f8784a.dismiss();
        }
        ReaderEnv.get().setReceivePushes(z);
        this.f8785b.f8783a.m12047a();
    }

    /* renamed from: a */
    public void mo1183a(String str) {
        if (this.f8784a != null) {
            this.f8784a.dismiss();
        }
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8785b.f8783a.getContext(), (CharSequence) str, 1).show();
        }
    }
}
