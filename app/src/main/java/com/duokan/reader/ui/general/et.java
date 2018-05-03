package com.duokan.reader.ui.general;

import android.view.View;
import com.duokan.core.ui.AnimUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

final class et implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ WeakReference f7168a;
    /* renamed from: b */
    final /* synthetic */ View f7169b;

    et(WeakReference weakReference, View view) {
        this.f7168a = weakReference;
        this.f7169b = view;
    }

    public /* synthetic */ Object call() {
        return m10571a();
    }

    /* renamed from: a */
    public Boolean m10571a() {
        es esVar = (es) this.f7168a.get();
        if (esVar == null || esVar.f7131a != this.f7169b) {
            return Boolean.valueOf(true);
        }
        boolean z;
        boolean z2;
        if (esVar.f7134d != this.f7169b.getWidth() || esVar.f7135e != this.f7169b.getHeight()) {
            esVar.f7134d = this.f7169b.getWidth();
            esVar.f7135e = this.f7169b.getHeight();
            esVar.invalidateSelf();
            z = true;
        } else if (esVar.f7132b && this.f7169b.isDirty()) {
            esVar.invalidateSelf();
            z = true;
        } else {
            z = false;
        }
        if (z || esVar.f7136f) {
            AnimUtils.m1922a(this.f7169b, (Callable) this);
        }
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }
}
