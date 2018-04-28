package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class il implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ik f8735a;

    il(ik ikVar) {
        this.f8735a = ikVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        try {
            this.f8735a.f8734a.b.pushHalfPageSmoothly(new MiAccountProfileSettingsController(this.f8735a.f8734a.getContext()), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8735a.f8734a.getContext(), (CharSequence) str, 0).show();
        }
    }
}
