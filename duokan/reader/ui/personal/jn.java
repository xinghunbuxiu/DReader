package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class jn implements u {
    final /* synthetic */ jm a;

    jn(jm jmVar) {
        this.a = jmVar;
    }

    public void onQueryAccountOk(a aVar) {
        try {
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new MiAccountProfileSettingsController(this.a.a.getContext()), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
