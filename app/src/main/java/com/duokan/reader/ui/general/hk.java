package com.duokan.reader.ui.general;

import com.duokan.core.app.C0301c;
import com.duokan.core.app.OnCancelListener;
import com.duokan.reader.common.C0613k;

class hk implements OnCancelListener {
    /* renamed from: a */
    final /* synthetic */ C0613k f7338a;
    /* renamed from: b */
    final /* synthetic */ hh f7339b;

    hk(hh hhVar, C0613k c0613k) {
        this.f7339b = hhVar;
        this.f7338a = c0613k;
    }

    public void onCancel(C0301c c0301c) {
        this.f7338a.m2796a(Boolean.valueOf(true));
    }
}
