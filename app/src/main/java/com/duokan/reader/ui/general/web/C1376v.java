package com.duokan.reader.ui.general.web;

import java.util.LinkedList;

/* renamed from: com.duokan.reader.ui.general.web.v */
class C1376v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Object f8178a;
    /* renamed from: b */
    final /* synthetic */ C1375u f8179b;

    C1376v(C1375u c1375u, Object obj) {
        this.f8179b = c1375u;
        this.f8178a = obj;
    }

    public void run() {
        if (this.f8179b.f8177a.mHotWord.isEmpty()) {
            if (this.f8178a != null && ((LinkedList) this.f8178a).size() > 0) {
                this.f8179b.f8177a.mHotWord.addAll((LinkedList) this.f8178a);
            }
            this.f8179b.f8177a.mSearchHintView.getAdapter().m8785a(false);
        }
    }
}
