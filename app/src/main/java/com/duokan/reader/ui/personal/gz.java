package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;
import java.util.concurrent.Callable;

class gz implements C0666x {
    /* renamed from: a */
    final /* synthetic */ Callable f8627a;
    /* renamed from: b */
    final /* synthetic */ boolean f8628b;
    /* renamed from: c */
    final /* synthetic */ fz f8629c;

    gz(fz fzVar, Callable callable, boolean z) {
        this.f8629c = fzVar;
        this.f8627a = callable;
        this.f8628b = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        try {
            this.f8629c.m11846a((ActivatedController) this.f8627a.call(), this.f8628b, null);
        } catch (Throwable th) {
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8629c.getContext(), (CharSequence) str, 0).show();
        }
    }
}
