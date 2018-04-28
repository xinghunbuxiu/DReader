package com.duokan.core.ui;

import android.view.View;
import java.util.concurrent.Callable;

final class ea extends ep {
    /* renamed from: a */
    final /* synthetic */ Callable f1210a;

    ea(View view, Callable callable) {
        this.f1210a = callable;
        super(view);
    }

    /* renamed from: a */
    protected boolean mo520a(View view) {
        try {
            return ((Boolean) this.f1210a.call()).booleanValue();
        } catch (Exception e) {
            return true;
        }
    }
}
