package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.ui.UTools;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

final class ev implements Callable {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ View b;

    ev(WeakReference weakReference, View view) {
        this.a = weakReference;
        this.b = view;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        eu euVar = (eu) this.a.get();
        if (euVar == null || euVar.a != this.b) {
            return Boolean.valueOf(true);
        }
        boolean z;
        boolean z2;
        if (euVar.d != this.b.getWidth() || euVar.e != this.b.getHeight()) {
            euVar.d = this.b.getWidth();
            euVar.e = this.b.getHeight();
            euVar.invalidateSelf();
            z = true;
        } else if (euVar.b && this.b.isDirty()) {
            euVar.invalidateSelf();
            z = true;
        } else {
            z = false;
        }
        if (z || euVar.f) {
            UTools.creatCallTask(this.b, (Callable) this);
        }
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }
}
