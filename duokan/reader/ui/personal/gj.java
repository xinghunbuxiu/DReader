package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class gj implements u {
    final /* synthetic */ gi a;

    gj(gi giVar) {
        this.a = giVar;
    }

    public void onQueryAccountOk(a aVar) {
        try {
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new MiAccountProfileSettingsController(this.a.a.getContext()), null);
        } catch (Throwable th) {
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
