package com.duokan.reader.ui.general.web;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.ui.general.web.z */
class C1380z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Object f8184a;
    /* renamed from: b */
    final /* synthetic */ C1379y f8185b;

    C1380z(C1379y c1379y, Object obj) {
        this.f8185b = c1379y;
        this.f8184a = obj;
    }

    public void run() {
        if (this.f8184a == null) {
            this.f8185b.f8183a.getHotWord();
        } else if (((LinkedList) this.f8184a).size() > 0) {
            if (this.f8185b.f8183a.mHistory.isEmpty()) {
                this.f8185b.f8183a.mHistory.addAll((LinkedList) this.f8184a);
            } else {
                Iterator it = ((LinkedList) this.f8184a).iterator();
                while (it.hasNext()) {
                    this.f8185b.f8183a.addHistoryToList((String) it.next(), true);
                }
                this.f8185b.f8183a.writeHistory();
            }
            this.f8185b.f8183a.mSearchHintView.getAdapter().m8785a(true);
        } else {
            this.f8185b.f8183a.getHotWord();
        }
        this.f8185b.f8183a.mIsHistoryLoaded = true;
    }
}
