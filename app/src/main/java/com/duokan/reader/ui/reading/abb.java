package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderFeature;

class abb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ aaw f9376a;

    abb(aaw aaw) {
        this.f9376a = aaw;
    }

    public void run() {
        if (this.f9376a.f9363d.f.mo1038k()) {
            this.f9376a.f9363d.m12867H();
        } else if (!this.f9376a.f9363d.f.m4170W()) {
            ((ReaderFeature) AppContext.getAppContext(this.f9376a.f9363d.getContext()).queryFeature(ReaderFeature.class)).downloadBooks(this.f9376a.f9363d.f);
        }
    }
}
