package com.duokan.reader.ui.general.web;

import java.util.Iterator;
import java.util.LinkedList;

class y implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ x b;

    y(x xVar, Object obj) {
        this.b = xVar;
        this.a = obj;
    }

    public void run() {
        if (this.a == null) {
            this.b.a.getHotWord();
        } else if (((LinkedList) this.a).size() > 0) {
            if (this.b.a.mHistory.isEmpty()) {
                this.b.a.mHistory.addAll((LinkedList) this.a);
            } else {
                Iterator it = ((LinkedList) this.a).iterator();
                while (it.hasNext()) {
                    this.b.a.addHistoryToList((String) it.next(), true);
                }
                this.b.a.writeHistory();
            }
            this.b.a.mSearchHintView.getAdapter().a(true);
        } else {
            this.b.a.getHotWord();
        }
        this.b.a.mIsHistoryLoaded = true;
    }
}
