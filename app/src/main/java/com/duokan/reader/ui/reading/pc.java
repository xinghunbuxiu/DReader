package com.duokan.reader.ui.reading;

import com.duokan.reader.ui.C0437t;

class pc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ pb f10773a;

    pc(pb pbVar) {
        this.f10773a = pbVar;
    }

    public void run() {
        ((C0437t) this.f10773a.f10772a.getContext().queryFeature(C0437t.class)).pushHalfPageSmoothly(new iz(this.f10773a.f10772a.getContext(), this.f10773a.f10772a.f, new pd(this)), null);
    }
}
