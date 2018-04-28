package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class gx implements C0666x {
    /* renamed from: a */
    final /* synthetic */ gw f8625a;

    gx(gw gwVar) {
        this.f8625a = gwVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        try {
            ((ReaderFeature) this.f8625a.f8624a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new MiAccountProfileSettingsController(this.f8625a.f8624a.getContext()), null);
        } catch (Throwable th) {
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8625a.f8624a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
