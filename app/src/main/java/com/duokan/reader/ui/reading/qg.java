package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;

class qg implements Runnable {
    final /* synthetic */ qf a;

    qg(qf qfVar) {
        this.a = qfVar;
    }

    public void run() {
        UmengManager.get().onEvent("V2_READING_OPTION_MORE_MORE");
        this.a.a.a.a(1, 0);
        ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new vq(this.a.a.getContext()), null);
    }
}
