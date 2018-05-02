package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.s;
import com.duokan.reader.ui.general.be;

class iy implements s {
    final /* synthetic */ ix a;

    iy(ix ixVar) {
        this.a = ixVar;
    }

    public void a(boolean z) {
        ReaderEnv.get().setReceivePushes(z);
        this.a.a.a();
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 1).show();
        }
    }
}
