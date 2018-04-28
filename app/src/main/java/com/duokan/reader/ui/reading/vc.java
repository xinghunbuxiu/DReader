package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;

class vc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ vb f11042a;

    vc(vb vbVar) {
        this.f11042a = vbVar;
    }

    public void run() {
        UmengManager.get().onEvent("V2_READING_OPTION_MORE_MORE");
        this.f11042a.f11041a.f11020a.mo2040a(1, 0);
        ((ReaderFeature) this.f11042a.f11041a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new wd(this.f11042a.f11041a.getContext()), null);
    }
}
