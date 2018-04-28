package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;

class qq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ qp f10871a;

    qq(qp qpVar) {
        this.f10871a = qpVar;
    }

    public void run() {
        UmengManager.get().onEvent("V2_READING_OPTION_MORE_MORE");
        this.f10871a.f10870a.f10853a.mo2040a(1, 0);
        ((ReaderFeature) this.f10871a.f10870a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new wd(this.f10871a.f10870a.getContext()), null);
    }
}
