package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class gm implements as {
    /* renamed from: a */
    final /* synthetic */ ci f7892a;

    gm(ci ciVar) {
        this.f7892a = ciVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7892a.f7581b.mEditFeedController != null) {
            this.f7892a.f7581b.mEditFeedController.requestDetach();
            this.f7892a.f7581b.mEditFeedController = null;
        }
    }
}
