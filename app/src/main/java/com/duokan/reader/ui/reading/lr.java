package com.duokan.reader.ui.reading;

import com.duokan.core.app.IScreenRotationChangedListener;

class lr implements IScreenRotationChangedListener {
    /* renamed from: a */
    final /* synthetic */ ll f10581a;

    lr(ll llVar) {
        this.f10581a = llVar;
    }

    /* renamed from: a */
    public void ScreenRotationChanged(int i) {
        if (this.f10581a.getActiveImageView() != null) {
            this.f10581a.m14228a(i, true);
        }
    }
}
