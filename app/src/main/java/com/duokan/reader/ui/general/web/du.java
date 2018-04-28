package com.duokan.reader.ui.general.web;

import android.provider.Settings.Secure;
import com.duokan.reader.DkApp;
import java.util.concurrent.Callable;

class du implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ ci f7747a;

    du(ci ciVar) {
        this.f7747a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11092a();
    }

    /* renamed from: a */
    public Boolean m11092a() {
        boolean z = true;
        if (Secure.getInt(DkApp.get().getContentResolver(), "accessibility_enabled") != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
