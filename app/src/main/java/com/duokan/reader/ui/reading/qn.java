package com.duokan.reader.ui.reading;

import com.duokan.core.sys.UThread;

class qn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ qm f10868a;

    qn(qm qmVar) {
        this.f10868a = qmVar;
    }

    public void run() {
        UThread.postDelayed(new qo(this), 500);
    }
}
