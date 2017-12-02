package com.duokan.reader.ui.general.web;

import java.util.LinkedList;

class u implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ t b;

    u(t tVar, Object obj) {
        this.b = tVar;
        this.a = obj;
    }

    public void run() {
        if (this.b.a.mHotWord.isEmpty()) {
            if (this.a != null && ((LinkedList) this.a).size() > 0) {
                this.b.a.mHotWord.addAll((LinkedList) this.a);
            }
            this.b.a.mSearchHintView.getAdapter().a(false);
        }
    }
}
